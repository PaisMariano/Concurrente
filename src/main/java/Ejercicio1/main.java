package main.java.Ejercicio1;

public class main{

    public static void main(String[]args){

        Contador contador = new Contador();

        SumadorThread sumadorThread1 = new SumadorThread(contador, 0);
        SumadorThread sumadorThread2 = new SumadorThread(contador, 1);
        SumadorThread sumadorThread3 = new SumadorThread(contador, 2);

        sumadorThread1.start();
        sumadorThread2.start();
        sumadorThread3.start();

    }
}