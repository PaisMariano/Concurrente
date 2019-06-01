package main.java.TP1;

public class PoisonPillTask extends Task {

    @Override
    public void run() {
        throw new PoisonException();
    }
}
