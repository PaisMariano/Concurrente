package main.java.TP1;

public class WorkGiver extends Thread {
    private Buffer buffer;

    public WorkGiver(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        Task tempTask = new Task();

        while (true) {
            this.buffer.push(tempTask);
            System.out.println("WorkGiver entrega trabajo.");

        }

    }
}