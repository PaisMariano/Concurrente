package main.java.TP1;

import java.util.ArrayList;
import java.util.List;

public class ConcurRadixSort {

    private ThreadPool threadPool;
    private List<Integer> inputList;

    public ConcurRadixSort(int workersAmount, List<Integer> list, int bufferSize){
        this.inputList = list;
        this.threadPool = new ThreadPool(workersAmount, bufferSize);

    }

    public List radixSort(List<Integer> list){

        for (int i=0; i < 32; ++i){
            List<List<Integer>> aux = this.split(list, i);
            List auxList = new ArrayList();

            auxList.addAll(aux.get(0));
            auxList.addAll(aux.get(1));

            list = auxList;

        }
        return list;
    }

    private List<List<Integer>> split(List<Integer> list, int i) {
        List zeros = new ArrayList();
        List ones  = new ArrayList();
        int mask = 1 << i;

        list.stream().forEach((val) -> {if (0 != (val & mask)){
                                            ones.add(val);
                                        }else{
                                            zeros.add(val);
                                        }});

        List<List<Integer>> auxList = new ArrayList();
        auxList.add(zeros);
        auxList.add(ones);

        return auxList;

    }
    public ThreadPool getThreadPool(){
        return this.threadPool;
    }
}