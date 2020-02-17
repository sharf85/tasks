package com.telran;

public class LazyInspiredClerk extends AbstractClerk {

    private static final int INSPIRED_CREDITS_NUMBER = 3;
    double inspirationCoef;
    int inspirationProbability;


    public LazyInspiredClerk(int minTime,
                             int maxTime,
                             int creditsNumber,
                             String name,
                             double inspirationCoef,
                             int inspirationProbability) {
        super(minTime, maxTime, creditsNumber, name);
        this.inspirationCoef = inspirationCoef;
        this.inspirationProbability = inspirationProbability;
    }

    @Override
    public void run() {
        int inspiredCreditsLeft = 0;
        for (int i = 0; i < creditsNumber; i++) {
            if (inspiredCreditsLeft == 0 && random.nextInt(100) < inspirationProbability) {
                inspiredCreditsLeft = INSPIRED_CREDITS_NUMBER;
            }

            int timeToSleep = minTime + random.nextInt(maxTime - minTime);
            if (inspiredCreditsLeft > 0) {
                timeToSleep = (int) (timeToSleep / inspirationCoef);
                inspiredCreditsLeft--;
            }

            try {
                Thread.sleep(timeToSleep);
            } catch (InterruptedException e) {
                return;
            }
        }
        finishTime = System.currentTimeMillis();
    }
}
