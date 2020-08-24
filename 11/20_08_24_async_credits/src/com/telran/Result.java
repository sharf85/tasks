package com.telran;

public class Result {

    private final String name;
    private final int workingTime;

    public Result(String name, int workingTime) {
        this.name = name;
        this.workingTime = workingTime;
    }

    public String getName() {
        return name;
    }

    public int getWorkingTime() {
        return workingTime;
    }
}
