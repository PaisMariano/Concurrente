package main.java.Ejercicio3;

public class Buffer {

    private int cantidadElementos;
    private Object[] data;
    private int begin = 0, end = 0;

    public Buffer(int tamaño){
        this.cantidadElementos = tamaño - 1;
        this.data = new Object[tamaño];
    }

    public synchronized void push(Object o){
        while (isFull()) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        data[begin] = o;
        begin = next(begin);
        notifyAll();
    }

    public synchronized Object pop(){
        while (isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Object result = data[end];
        end = next(end);
        notifyAll();
        return result;
    }

    private boolean isEmpty() { return begin == end; }
    private boolean isFull() { return next(begin) == end; }
    private int next(int i) { return (i+1)%(this.cantidadElementos+1); }
}
