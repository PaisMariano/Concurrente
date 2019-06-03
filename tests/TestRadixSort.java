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
    public void testUnWorkerDosNumerosAlAzarDiezBufferUnoTamañoTask() {
        List<Integer> tempList = createRandomIntegerListOfSize(2);
        concurRadixSort = new ConcurRadixSort(1, tempList,10,1 );
        Collections.sort(tempList);
        concurRadixSort.radixSort();
        Assert.assertEquals(tempList, concurRadixSort.radixSort());
    }

    @Test
    public void testDosWorkerCuatroNumerosAlAzarDiezBufferDosTamañoTask() {
        List<Integer> tempList = createRandomIntegerListOfSize(4);
        concurRadixSort = new ConcurRadixSort(2, tempList,10,2 );
        Collections.sort(tempList);
        concurRadixSort.radixSort();
        Assert.assertEquals(tempList, concurRadixSort.radixSort());
    }

    @Test
    public void testDiezWorkerDiezNumerosAlAzarDiezBufferDosTamañoTask() {
        List<Integer> tempList = createRandomIntegerListOfSize(10);
        concurRadixSort = new ConcurRadixSort(10, tempList,10,2 );
        Collections.sort(tempList);
        concurRadixSort.radixSort();
        Assert.assertEquals(tempList, concurRadixSort.radixSort());
    }

    @Test
    public void testMilWorkerDiezMilNumerosAlAzarVeinteBufferDiezTamañoTask() {
        List<Integer> tempList = createRandomIntegerListOfSize(10000);
        concurRadixSort = new ConcurRadixSort(1000, tempList,20,10 );
        Collections.sort(tempList);
        concurRadixSort.radixSort();
        Assert.assertEquals(tempList, concurRadixSort.radixSort());
    }

    @Test
    public void testDiezMilWorkerUnMillonNumerosAlAzarCienBufferCincuentaTamañoTask() {
        List<Integer> tempList = createRandomIntegerListOfSize(1000000);
        concurRadixSort = new ConcurRadixSort(10000, tempList,100,50 );
        Collections.sort(tempList);
        concurRadixSort.radixSort();
        Assert.assertEquals(tempList, concurRadixSort.radixSort());
    }
}
