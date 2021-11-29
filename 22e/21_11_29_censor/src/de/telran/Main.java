package de.telran;

public class Main {

    public static void main(String[] args) {

        String[] badWords = {"abc", "xyz", "ffkk"};

        Censor censor = new Censor(badWords);

        System.out.println(censor.verify("xyz knows the answer to your question!"));
        System.out.println(censor.verify("Go and abc yourself!"));
        System.out.println(censor.verify("Hello, dear grandma!"));

        badWords[0] = "cba";
        badWords[1] = "zyx";
        badWords[2] = "kkff";

        System.out.println(censor.verify("xyz knows the answer to your question!"));
        System.out.println(censor.verify("Go and abc yourself!"));
        System.out.println(censor.verify("Hello, dear grandma!"));

        Censor censor2 = new Censor(new String[]{"abc", "xyz", "ffkk", "1", "2"});

    }
}
