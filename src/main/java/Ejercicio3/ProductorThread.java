package main.java.Ejercicio3;

import java.util.Random;

public class ProductorThread extends Thread {

    Buffer buffer;
    Object object = new Object();

    public ProductorThread(Buffer buffer){
        this.buffer = buffer;
    }

    public void run(){
        while(true) {
            this.buffer.push(this.object);
            System.out.println("Agregado " + this.object);
        }
    }
}
