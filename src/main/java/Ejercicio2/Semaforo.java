package main.java.Ejercicio2;

import java.util.concurrent.locks.Condition;

public class Semaforo {

    private Condition noCero;
    private int permisos = 0;

    public Semaforo(int permisos){
        this.permisos = permisos;
    }

    public synchronized void acquire() throws InterruptedException {
        while (permisos > 0)
            this.noCero.wait();
        permisos++;
    }

    public synchronized void release() {
        if (permisos > 0)
            permisos--;
        this.noCero.notifyAll();
    }

}
