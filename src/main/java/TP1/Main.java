package main.java.TP1;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[]args){
        ConcurRadixSort concur = new ConcurRadixSort();
        ArrayList<Integer> arraycito = new ArrayList();

        arraycito.add(1);
        arraycito.add(0);
        arraycito.add(1);
        arraycito.add(1);
        arraycito.add(0);
        arraycito.add(0);
        arraycito.add(1);
        arraycito.add(0);
        arraycito.add(1);

        //System.out.println(arraycito);
        //List temp = concur.radixSort(arraycito);
        //System.out.println(temp);

        ThreadPool tPool = new ThreadPool(10, 100);
        tPool.launch();
    }
}
