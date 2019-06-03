package main.java.TP1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RadixSortTask extends Task {
    private int taskId;
    private List<Integer> toSortList;
    private Map<Integer, List<List<Integer>>> zerosAndOnesList;
    private int i;
    private int from;
    private int to;
    private EnglishSemaphore englishSemaphore;
    private java.util.concurrent.Semaphore mutex;

    public RadixSortTask(List<Integer> toSortList,
                         Map<Integer, List<List<Integer>>> zerosAndOnesList,
                         int i,
                         int from,
                         int to,
                         int taskId,
                         EnglishSemaphore englishSemaphore,
                         java.util.concurrent.Semaphore mutex){

        this.taskId = taskId;
        this.toSortList = toSortList;
        this.zerosAndOnesList = zerosAndOnesList;
        this.i = i;
        this.from = from;
        this.to = to;
        this.englishSemaphore = englishSemaphore;
        this. mutex = mutex;
    }

    @Override
    public void run() {
        List<List<Integer>> tempList = this.split(this.toSortList, i, from, to);
        try {
            this.mutex.acquire();
            this.addEveryone(taskId, tempList);
            this.mutex.release();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private List<List<Integer>> split(List<Integer> toSortList, int i, int from, int to) {
        List<Integer> zeros = new ArrayList();
        List<Integer> ones  = new ArrayList();
        int mask = 1 << i;
        for (int j = from; j <= to; j++) {
            if (0 != (toSortList.get(j) & mask)){
                ones.add(toSortList.get(j));
            }else{
                zeros.add(toSortList.get(j));
            }
        }
        List<List<Integer>> auxList = new ArrayList();
        auxList.add(zeros);
        auxList.add(ones);

        return auxList;
    }

    private synchronized void addEveryone(Integer taskId, List<List<Integer>> list) {
        this.zerosAndOnesList.put(taskId, list);
        this.englishSemaphore.release();
    }

}

