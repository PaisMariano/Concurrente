package main.java.TP1;

import java.util.ArrayList;
import java.util.List;

public class RadixSortTask extends Task {
    private List<Integer> toSortList;
    private List<List<Integer>> zerosAndOnesList;
    private int i;
    private int from;
    private int to;
    private Semaphore semaphore;

    public RadixSortTask(List<Integer> toSortList,
                         List<List<Integer>> zerosAndOnesList,
                         int i,
                         int from,
                         int to,
                         Semaphore semaphore){

        this.toSortList = toSortList;
        this.zerosAndOnesList = zerosAndOnesList;
        this.i = i;
        this.from = from;
        this.to = to;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        this.addEveryone(this.split(this.toSortList, i, from, to));
    }
    private List<List<Integer>> split(List<Integer> toSortList, int i, int from, int to) {
        List zeros = new ArrayList();
        List ones  = new ArrayList();
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

    private void addEveryone(List<List<Integer>> list){
        this.zerosAndOnesList.addAll(list);
        this.semaphore.release();
    }

}

