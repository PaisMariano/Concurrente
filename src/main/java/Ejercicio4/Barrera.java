package main.java.Ejercicio4;

public class Barrera {
    private int input;
    private int cantAutos;

    public Barrera(int input){
        this.input = input;
        this.cantAutos = 0;
    }

    public synchronized void esperar() throws InterruptedException {
        cantAutos++;
        while(this.input > cantAutos)
            this.wait();
        notify();
    }
}
