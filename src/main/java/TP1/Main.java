package main.java.TP1;

public class Main {

    public static void main(String[]args){
        ThreadPool tPool = new ThreadPool(10, 100);
        tPool.launch();
    }
}
