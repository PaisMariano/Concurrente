package main.java.TP1;

public class Worker extends Thread{
    private Buffer buffer;
    private int taskAmount;
    private int threadId;

    public Worker(Buffer buffer, int taskAmount, int threadId){
        this.threadId   = threadId;
        this.buffer     = buffer;
        this.taskAmount = taskAmount;
    }

    public void run(){
        while (taskAmount > 0){
            this.buffer.pop().run();
            System.out.println("Worker " + this.threadId + " trabaja.");
            taskAmount--;
        }
    }
}
