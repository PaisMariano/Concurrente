package main.java.TP1;

import java.util.ArrayList;
import java.util.List;

public class ConcurRadixSort {

    private ThreadPool threadPool;
    private List<Integer> inputList;
    private int pretendedDivisionSize;

    public ConcurRadixSort(int workersAmount, List<Integer> list, int bufferSize){
        this.inputList = list;
        this.threadPool = new ThreadPool(workersAmount, bufferSize);
        this.pretendedDivisionSize = 2;
    }
    public void radixSort() throws InterruptedException {
        int taskAmount = pretendedDivisionSize;
        Semaphore semaphore;
        if (inputList.size() % this.pretendedDivisionSize != 0) { //averiguo cantidad de divisiones
            taskAmount = this.pretendedDivisionSize + 1;
        }
        for (int i=0; i < 32; ++i) {
            List<List<Integer>> tempList = new ArrayList<>();
            semaphore = new Semaphore(taskAmount);
            int last = inputList.size() - 1;
            int from = 0;
            int to   = -1;
            for (int k = 0; k < taskAmount; k++) {

                System.out.println("tempList Anterior: " + tempList);
                to = to + (inputList.size() / this.pretendedDivisionSize);
                if ((taskAmount - k) == 1) { to = last; } //Cuando estoy en el ultimo caso to tiene que ser last.

                this.launch(new RadixSortTask(this.inputList, tempList, i, from, to, semaphore));

                from = to + 1;
            }
            semaphore.acquire(); //espero a que terminen los workers.
            this.orderUp(tempList);


        }
    }

    private void orderUp(List<List<Integer>> tempList) {

            List sortedList = new ArrayList();

            for (int i = 0; i < tempList.size(); i = i + 2) {
                sortedList.addAll(tempList.get(i));
            }
            for (int j = 1; j < tempList.size(); j = j + 2) {
                sortedList.addAll(tempList.get(j));
            }

            this.inputList = sortedList;

    }

    public void launch(Task task){ this.threadPool.launch(task); }

    public ThreadPool getThreadPool(){ return this.threadPool; }

    public List<Integer> getInputList() { return inputList;}
}