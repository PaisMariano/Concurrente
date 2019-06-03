package main.java.TP1;

import java.util.ArrayList;

public class Main {

    public static void main(String[]args) throws InterruptedException {

        ArrayList<Integer> arraycito = new ArrayList();
        arraycito.add(2);
        arraycito.add(5);
        arraycito.add(1);
        arraycito.add(4);
        //arraycito.add(2);

        ConcurRadixSort crs = new ConcurRadixSort(3, arraycito, 10);
        Task dummyTask  = new DummyTask();
        Task poisonTask = new PoisonPillTask();

        System.out.println(arraycito);

        crs.radixSort();


    }
}
