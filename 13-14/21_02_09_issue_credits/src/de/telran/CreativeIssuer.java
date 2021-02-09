package de.telran;

import java.util.List;

public class CreativeIssuer extends Issuer {

    final List<Score> scores;
    final int turboMin;
    final int turboMax;
    final int turboCapacity;
    final int inspiredProbability;

    public CreativeIssuer(String name,
                          int min,
                          int max,
                          int creditsNum,
                          List<Score> scores,
                          int turboMin,
                          int turboMax,
                          int turboCapacity,
                          int inspiredProbability
    ) {
        super(name, min, max, creditsNum, scores);
        this.scores = scores;
        this.turboMin = turboMin;
        this.turboMax = turboMax;
        this.turboCapacity = turboCapacity;
        this.inspiredProbability = inspiredProbability;
    }

    @Override
    protected void issueCredits() {
        int turboLeft = 0;

        for (int i = 0; i < creditsNum; i++) {

            if (turboLeft == 0 && toInspire())
                turboLeft = turboCapacity;

            int issueTime;
            if (turboLeft > 0) {
                issueTime = generateIssuingTime(turboMax, turboMin);
                turboLeft--;
            } else {
                issueTime = generateIssuingTime(max, min);
            }

            try {
                Thread.sleep(issueTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    boolean toInspire() {
        return rnd.nextInt(100) < inspiredProbability;
    }
}
