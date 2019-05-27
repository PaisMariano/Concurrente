package main.java.Ejercicio6;

public class LectoresEscritores {
    private int cantEscritores = 0;
    private int cantLectores = 0;
    private int escritoresEsperando = 0;

    public synchronized void comenzarLectura() throws InterruptedException {
        while(cantEscritores > 0 || escritoresEsperando > 0)
            wait();
        cantLectores++;
    }

    public synchronized void comenzarEscritura() throws InterruptedException {
        escritoresEsperando++;
        while(cantLectores > 0 || cantEscritores > 0)
            wait();
        escritoresEsperando--;
        cantEscritores++;
    }

    public synchronized void terminarEscritura(){
        cantEscritores--;
        notify();
        if (escritoresEsperando == 0)
            notifyAll();
    }
}