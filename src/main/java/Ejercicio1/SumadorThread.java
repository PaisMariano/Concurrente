package main.java.Ejercicio1;

public class SumadorThread extends Thread {
    private Contador contador;
    private int threadId;

    public SumadorThread (Contador contador, int id) {
        this.contador = contador;
        this.threadId = id;
    }

    public void run(){

        while (this.contador.getContador() < 5000){
            contador.incrementar();
            System.out.println("valor: " + this.contador.getContador() + " threadId: " + this.threadId);
        }
    }
}
