package main.java.TP1;

import java.util.ArrayList;

public class Main {

    public static void main(String[]args){

        ArrayList<Integer> arraycito = new ArrayList();

        arraycito.add(5);
        arraycito.add(4);
        arraycito.add(10);
        arraycito.add(24);
        arraycito.add(1);
        arraycito.add(6);
        arraycito.add(15);
        arraycito.add(3);
        arraycito.add(8);

        ConcurRadixSort crs = new ConcurRadixSort(10, arraycito, 5);
        Task dummyTask  = new DummyTask();
        Task task       = new RadixSortTask(arraycito);
        Task poisonTask = new PoisonPillTask();
        int i = 20; // Creo 20 dummyTask

        while (i > 0){
            crs.getThreadPool().launch(dummyTask);
            i--;
        }

        crs.getThreadPool().stop();

    }
}
