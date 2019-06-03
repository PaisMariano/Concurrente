package main.java.TP1;

public class ThreadPool {
    private Buffer buffer;
    private int workersAmount;

    public ThreadPool(int workersAmount, int bufferSize) {
        this.workersAmount = workersAmount;
        this.buffer = new Buffer(bufferSize);
        int threadId = 0;

        while (threadId < workersAmount) {
            Worker tempWorker = new Worker(this.buffer, threadId);
            tempWorker.start();
            threadId++;
        }
    }
    public void launch(Task task){
        this.buffer.push(task);
    }

    public void stop(){
        for (int i = 0; i < workersAmount; i++) {
            this.launch(new PoisonPillTask());
        }
    }
}
