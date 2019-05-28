package main.java.TP1;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[]args){
        ConcurRadixSort concur = new ConcurRadixSort();
        ArrayList<Integer> arraicito = new ArrayList();

        arraicito.add(1);
        arraicito.add(0);
        arraicito.add(1);
        arraicito.add(1);
        arraicito.add(1);
        arraicito.add(0);
        arraicito.add(1);
        arraicito.add(0);
        arraicito.add(1);
        arraicito.add(1);
        arraicito.add(0);
        arraicito.add(0);
        arraicito.add(1);
        arraicito.add(0);
        arraicito.add(1);
        arraicito.add(0);
        arraicito.add(0);
        arraicito.add(1);
        arraicito.add(0);
        arraicito.add(1);

        System.out.println(arraicito);
        List temp = concur.radixSort(arraicito);
        System.out.println(temp);

        //ThreadPool tPool = new ThreadPool(10, 100);
        //tPool.launch();
    }
}
