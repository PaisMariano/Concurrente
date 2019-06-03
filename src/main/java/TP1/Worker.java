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
                System.out.println("Worker " + this.threadId + " trabaja.");
            }
        }catch (PoisonException m){
            this.flag = false;
            System.out.println("Termino el Worker: " + this.threadId);}
    }
}
