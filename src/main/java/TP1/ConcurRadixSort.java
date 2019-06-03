package main.java.TP1;

import java.util.*;
import java.util.concurrent.Semaphore;

public class ConcurRadixSort {

    private ThreadPool threadPool;
    private List<Integer> inputList;
    private int pretendedDivisionSize;
    private EnglishSemaphore englishSemaphore;
    private Semaphore mutex;

    public ConcurRadixSort(int workersAmount, List<Integer> inputList, int bufferSize, int taskSize){
        this.inputList = inputList;
        this.threadPool = new ThreadPool(workersAmount, bufferSize);
        this.pretendedDivisionSize = taskSize;
    }
    public void radixSort() {
        int taskAmount = pretendedDivisionSize;
        if (inputList.size() % this.pretendedDivisionSize != 0) //averiguo cantidad de divisiones
            taskAmount = this.pretendedDivisionSize + 1;

        for (int i=0; i < 32; ++i) {
            mutex = new Semaphore(1);
            englishSemaphore = new EnglishSemaphore(taskAmount);
            Map<Integer, List<List<Integer>>> tempMap = new HashMap<>();
            int last = inputList.size() - 1;
            int from =  0;
            int to   = -1;

            for (int taskId = 0; taskId < taskAmount; taskId++) {

                to = to + (inputList.size() / this.pretendedDivisionSize);
                if ((taskAmount - taskId) == 1) { to = last; } //Cuando estoy en el ultimo caso to tiene que ser last.

                this.launch(new RadixSortTask(this.inputList, tempMap, i, from, to, taskId, englishSemaphore, mutex));
                from = to + 1;
            }
            englishSemaphore.acquire(); //espero a que terminen los workers.
            this.orderUp(tempMap);
        }
        System.out.println("Lista de Salida: " + this.inputList);
    }

    private void orderUp(Map<Integer, List<List<Integer>>> tempMap) {
        List<Integer> sortedList = new ArrayList();
        TreeMap<Integer, List<List<Integer>>> sorted = new TreeMap<>(tempMap);
        Set<Map.Entry<Integer, List<List<Integer>>>> mappings = sorted.entrySet();

        for(Map.Entry<Integer, List<List<Integer>>> mapping : mappings) {
                sortedList.addAll(mapping.getValue().get(0));
        }
        for(Map.Entry<Integer, List<List<Integer>>> mapping : mappings) {
                sortedList.addAll(mapping.getValue().get(1));
        }
        this.inputList = sortedList;
    }

    public void launch(Task task){ this.threadPool.launch(task); }

    public ThreadPool getThreadPool(){ return this.threadPool; }

    public List<Integer> getInputList() { return inputList;}
}