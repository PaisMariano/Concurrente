package main.java.TP1;

public class SemaphoreReal {

    private int permits;

    public SemaphoreReal(int permits){ this.permits = permits; }

    public synchronized void acquire() {
        while (this.permits == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void release() {
        this.permits++;
        this.notify();
    }
}