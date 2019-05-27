package main.java.Ejercicio1;

public class DecrementadorThread {
    private Contador contador;
    private int threadId;

    public DecrementadorThread(Contador contador, int id) {
        this.contador = contador;
        this.threadId = id;
    }

    public void run(){

        while (this.contador.getContador() < 5000){
            contador.decrementar();
            System.out.println("valor: " + this.contador.getContador() + " threadId: " + this.threadId);
        }
    }
}
