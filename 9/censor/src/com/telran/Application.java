package com.telran;

public class Application {

    public static void main(String[] args) {
        String[] vocab = {"vasya", "petya", "masha"};

        Censor censor = new Censor(vocab);

        vocab[2] = "Maria";
    }
}
