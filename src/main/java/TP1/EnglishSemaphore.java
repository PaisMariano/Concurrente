package main.java.TP1;

public class EnglishSemaphore {

        private int permits = 0;

    public EnglishSemaphore(int permits){ this.permits = permits; }

    public synchronized void acquire() {
        while (permits > 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void release() {
        permits--;
        if (permits == 0)
            this.notify();
    }
}

