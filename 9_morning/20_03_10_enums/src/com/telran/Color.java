package com.telran;

public enum Color {

    RED(0xFF0000), GREEN(0x00FF00), BLUE(0x0000FF);

    private int code;

    Color(int code) {
        this.code = code;
        System.out.println("Inside the enum constructor");
    }

    public int getCode() {
        return code;
    }

}
