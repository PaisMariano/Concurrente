package main.java.TP1;

import java.util.ArrayList;

public class Main {

    public static void main(String[]args) {

        ArrayList<Integer> arraycito = new ArrayList();
        arraycito.add(2);
        arraycito.add(5);
        arraycito.add(1);
        arraycito.add(4);
        arraycito.add(110);
        arraycito.add(80);
        arraycito.add(45);
        arraycito.add(22);
        arraycito.add(12);
        arraycito.add(50);
        arraycito.add(15);
        arraycito.add(28);
        arraycito.add(16);
        arraycito.add(67);
        arraycito.add(40);
        arraycito.add(45);
        arraycito.add(48);
        arraycito.add(34);
        arraycito.add(90);
        arraycito.add(55);

        ConcurRadixSort crs = new ConcurRadixSort(6, arraycito, 2, 5);
        Task dummyTask  = new DummyTask();
        Task poisonTask = new PoisonPillTask();

        System.out.println("Lista de entrada: " + arraycito);

        crs.radixSort();
    }
}
