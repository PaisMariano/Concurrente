package main.java.TP1;

import java.util.concurrent.Semaphore;

public class Worker extends Thread {
    private Buffer buffer;
    private int threadId;
    private boolean flag;
    private Semaphore mutex;

    public Worker(Buffer buffer, int threadId, Semaphore mutex) {
        this.threadId = threadId;
        this.buffer = buffer;
        this.flag = true;
        this.mutex = mutex;
    }

    public void run() {
        try {
            while (this.flag) {
                this.mutex.acquire();
                this.buffer.pop().run();
                this.mutex.release();
                System.out.println("Worker " + this.threadId + " trabaja.");
            }
        }catch (PoisonException | InterruptedException m){
            this.flag = false;
            System.out.println("Termino el Worker: " + this.threadId);}
    }
}
