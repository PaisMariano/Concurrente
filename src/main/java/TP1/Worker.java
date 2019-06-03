package main.java.TP1;

public class Worker extends Thread {
    private Buffer buffer;
    private int threadId;
    private boolean flag;

    public Worker(Buffer buffer, int threadId) {
        this.threadId = threadId;
        this.buffer = buffer;
        this.flag = true;
    }

    public void run() {
        try {
            while (this.flag) {
                this.buffer.pop().run();
            }
        }catch (PoisonException m){
            this.flag = false;
        }
    }
}
