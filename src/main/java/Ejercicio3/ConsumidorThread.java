package main.java.Ejercicio3;

public class ConsumidorThread extends Thread {

        Buffer buffer;

        public ConsumidorThread(Buffer buffer){
            this.buffer = buffer;
        }

        public void run(){
            while(true)
                System.out.println("Quitado " + this.buffer.pop());

    }
}
