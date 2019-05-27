package main.java.TP1;

import java.util.ArrayList;
import java.util.List;

public class ThreadPool {
    private List<Worker> workers = new ArrayList();
    private Buffer buffer;

    public ThreadPool(int workersAmount, int bufferSize){

        this.buffer = new Buffer(bufferSize);
        int i = 0;

        WorkGiver workGiver = new WorkGiver(this.buffer);
        workGiver.start();

        while(i < workersAmount){
            this.workers.add(new Worker(buffer, 10, i));
            i++;}
    }

    public void launch(){
        workers.forEach(it -> it.start());
    }
}
