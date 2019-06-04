package main.java.TP1;

import java.util.List;
import java.util.Map;

public class MutexMonitor {
    public synchronized void addEveryOne(Map<Integer, List<List<Integer>>> zerosAndOnesMap,
                                         int taskId,
                                         List<List<Integer>> list){

        zerosAndOnesMap.put(taskId, list);
    }
}
