package main.java.TP1;

import java.util.ArrayList;
import java.util.List;

public class ConcurRadixSort {

    public List radixSort(List list){

        for (int i=0; i < 32; ++i){
            List<List> aux = this.split(list, i);
            List auxList = new ArrayList();

            auxList.addAll(aux.get(0));
            auxList.addAll(aux.get(1));
            System.out.println(auxList);

            list = auxList;

        }
        return list;
    }

    private List<List> split(List<Integer> list, int i) {
        List zeros = new ArrayList();
        List ones  = new ArrayList();
        int mask = 1 << i;

        list.stream().forEach((val) -> {if (1 == (val & mask)){
                                            ones.add(val);
                                        }else{
                                            zeros.add(val);
                                        }});

        ArrayList<List> auxList = new ArrayList();
        auxList.add(zeros);
        auxList.add(ones);

        return auxList;
    }
}