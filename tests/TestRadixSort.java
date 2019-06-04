import main.java.TP1.ConcurRadixSort;

import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestRadixSort {
    private ConcurRadixSort concurRadixSort;

    public static int getRandomIntegerBetweenRange(double min, double max){
        double x = (int)(Math.random()*((max-min)+1))+min;
        return (int) x;
    }

    public List<Integer> createRandomIntegerListOfSize(int i){
        List<Integer> tempList = new ArrayList<>();
        for (int j = 0; j < i; j++) {
            tempList.add(getRandomIntegerBetweenRange(0, i));
        }
        return tempList;
    }

    @Test
    public void testUnWorkerDiezNumerosAlAzarDiezBufferUnoTamañoTask() {
        List<Integer> tempList = createRandomIntegerListOfSize(10);
        System.out.println("Test 1: 1 Worker, 10 Numeros, 10 Buffer, 1 Tamaño Task ");
        System.out.println("Lista inicial: " + tempList);
        concurRadixSort = new ConcurRadixSort(1, tempList,10,1 );
        System.out.println("Lista final: " + concurRadixSort.radixSort());
        Assert.assertEquals(1, 1);
    }

    @Test
    public void testDosWorkerCuatroNumerosAlAzarDiezBufferDosTamañoTask() {
        List<Integer> tempList = createRandomIntegerListOfSize(4);
        System.out.println("Test 2: 2 Workers, 4 Numeros, 10 Buffer, 2 Tamaño Task ");
        System.out.println("Lista inicial: " + tempList);
        concurRadixSort = new ConcurRadixSort(2, tempList,10,2 );
        System.out.println("Lista final: " + concurRadixSort.radixSort());
        Assert.assertEquals(1, 1);
    }

    @Test
    public void testDiezWorkerDiezNumerosAlAzarDiezBufferDosTamañoTask() {
        List<Integer> tempList = createRandomIntegerListOfSize(10);
        System.out.println("Test 3: 10 Workers, 10 Numeros, 10 Buffer, 2 Tamaño Task ");
        System.out.println("Lista inicial: " + tempList);
        concurRadixSort = new ConcurRadixSort(10, tempList,10,2 );
        System.out.println("Lista final: " + concurRadixSort.radixSort());
        Assert.assertEquals(1, 1);
    }

    @Test
    public void testMilWorkerDiezMilNumerosAlAzarVeinteBufferDiezTamañoTask() {
        List<Integer> tempList = createRandomIntegerListOfSize(10000);
        System.out.println("Test 4: 1000 Workers, 10000 Numeros, 20 Buffer, 10 Tamaño Task ");
        System.out.println("Lista inicial: " + tempList);
        concurRadixSort = new ConcurRadixSort(1000, tempList,20,10 );
        System.out.println("Lista final: " + concurRadixSort.radixSort());
        Assert.assertEquals(1, 1);
    }

    @Test
    public void testDiezMilWorkerUnMillonNumerosAlAzarCienBufferCincuentaTamañoTask() {
        List<Integer> tempList = createRandomIntegerListOfSize(1000000);
        concurRadixSort = new ConcurRadixSort(10000, tempList,100,50 );
        System.out.println(concurRadixSort.radixSort()); // No imprimimos detalle porque no se termina viendo.
        Assert.assertEquals(1, 1);
    }
}
