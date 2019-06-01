package main.java.TP1;

public class ThreadPool {
    private Buffer buffer;
    private int workersAmount;

    public ThreadPool(int workersAmount, int bufferSize) {
        this.workersAmount = workersAmount;
        this.buffer = new Buffer(bufferSize);
        int i = 0;

        while (i < workersAmount) {
            Worker tempWorker = new Worker(this.buffer, i);
            tempWorker.start();
            i++;
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
