package com.telran;

public class FinishInfo {

    /**
     * tarakan number
     */
    int tarakanId;

    /**
     * time of finish in milliseconds
     */
    long finishTime;

    public FinishInfo(int tarakanId, long finishTime) {
        this.tarakanId = tarakanId;
        this.finishTime = finishTime;
    }
}
