package main.java.TP1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Semaphore;

public class RadixSortTask extends Task {
    private int taskId;
    private List<Integer> toSortList;
    private Map<Integer, List<List<Integer>>> zerosAndOnesList;
    private int i;
    private int from;
    private int to;
    private EnglishSemaphore englishSemaphore;
    private MutexMonitor mutexMonitor;

    public RadixSortTask(List<Integer> toSortList,
                         Map<Integer, List<List<Integer>>> zerosAndOnesList,
                         int i,
                         int from,
                         int to,
                         int taskId,
                         EnglishSemaphore englishSemaphore,
                         MutexMonitor mutexMonitor){

        this.taskId = taskId;
        this.toSortList = toSortList;
        this.zerosAndOnesList = zerosAndOnesList;
        this.i = i;
        this.from = from;
        this.to = to;
        this.englishSemaphore = englishSemaphore;
        this.mutexMonitor = mutexMonitor;
    }

    @Override
    public void run() {
        List<List<Integer>> tempList = this.split(this.toSortList, i, from, to);
        this.mutexMonitor.addEveryOne(this.zerosAndOnesList, this.taskId, tempList);
        this.englishSemaphore.release();
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

}

