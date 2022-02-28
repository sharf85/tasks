package de.telran;

public class EchoMessenger implements Runnable {

    private String message;

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100000);
            } catch (InterruptedException e) {
                System.out.println("Echo runnable: " + message);
            }
        }
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
