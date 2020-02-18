package com.telran;

public class UsualClerk extends AbstractClerk {
    public UsualClerk(int minTime, int maxTime, int creditsNumber, String name) {
        super(minTime, maxTime, creditsNumber, name);
    }

    @Override
    public void run() {
        for (int i = 0; i < creditsNumber; i++) {
            int timeToSleep = minTime + random.nextInt(maxTime - minTime);
            try {
                Thread.sleep(timeToSleep);
            } catch (InterruptedException e) {
                return;
            }
        }

        finishTime = System.currentTimeMillis();
    }
}
