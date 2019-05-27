package main.java.Ejercicio3;

import main.java.Ejercicio1.SumadorThread;

public class main {

    public static void main(String[]args){

        Buffer buffer = new Buffer(10);

        ConsumidorThread consumidorThread = new ConsumidorThread(buffer);
        ProductorThread productorThread   = new ProductorThread(buffer);

        consumidorThread.start();
        productorThread.start();

    }
}
