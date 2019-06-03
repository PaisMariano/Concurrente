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
    private Semaphore semaphore;

    public RadixSortTask(List<Integer> toSortList,
                         Map<Integer, List<List<Integer>>> zerosAndOnesList,
                         int i,
                         int from,
                         int to,
                         int taskId,
                         Semaphore semaphore){

        this.taskId = taskId;
        this.toSortList = toSortList;
        this.zerosAndOnesList = zerosAndOnesList;
        this.i = i;
        this.from = from;
        this.to = to;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        this.addEveryone(taskId, this.split(this.toSortList, i, from, to));
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

    private synchronized void addEveryone(Integer taskId, List<List<Integer>> list){
        this.zerosAndOnesList.put(taskId, list);
        this.semaphore.release();
    }

}

