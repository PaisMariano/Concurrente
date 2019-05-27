package main.java.Ejercicio1;

public class Contador {

    private int contador = 0;

    public synchronized int incrementar(){
        contador = contador + 1;
        return contador;
    }
    public synchronized int decrementar(){
        contador = contador - 1;
        return contador;
    }
    public int getContador() { return this.contador;}
}
