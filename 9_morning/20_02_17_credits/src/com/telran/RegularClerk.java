package com.telran;

public class RegularClerk extends AbstractClerk {
    public RegularClerk(String name, int minTime, int maxTime, int creditsNum) {
        super(name, minTime, maxTime, creditsNum);
    }

    @Override
    public void run() {
        for (int i = 0; i < creditsNum; i++) {
            int toSleep = minTime + random.nextInt(maxTime - minTime);
            try {
                Thread.sleep(toSleep);
            } catch (InterruptedException e) {
                return;
            }
        }
        finishTime = System.currentTimeMillis();
    }
}
