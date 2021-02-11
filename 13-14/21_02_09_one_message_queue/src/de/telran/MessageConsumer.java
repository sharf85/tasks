package de.telran;

public class MessageConsumer implements Runnable {

    private final OneItemStringQueue queue;

    public MessageConsumer(OneItemStringQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String res = queue.removeLast();
                System.out.println(res);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
