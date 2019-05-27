package main.java.Ejercicio5;

public class Evento {
    private int ultimoPublish = 0;

    public synchronized void publish(){
        notifyAll();
        ultimoPublish++;
    }

    public synchronized void suscribe() throws InterruptedException {
        int actual = this.ultimoPublish;
        while(actual <= ultimoPublish){
            wait();
        }
    }
}
