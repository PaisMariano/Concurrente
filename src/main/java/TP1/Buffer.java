package main.java.TP1;

public class Buffer {

    private int elementsAmount;
    private Task[] data;
    private int begin = 0, end = 0;

    public Buffer(int size){
        this.elementsAmount = size - 1;
        this.data = new Task[size];
    }

    public synchronized void push(Task task){
        while (isFull()) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        data[begin] = task;
        begin = next(begin);
        notifyAll();
    }

    public synchronized Task pop(){
        while (isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Task result = data[end];
        end = next(end);
        notifyAll();
        return result;
    }

    private boolean isEmpty() { return begin == end; }
    private boolean isFull() { return next(begin) == end; }
    private int next(int i) { return (i+1)%(this.elementsAmount+1); }
}
