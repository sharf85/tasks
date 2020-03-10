package com.telran;

public class Main {

    public static void main(String[] args) {
        System.out.println(TransactionState.CANCELLED.name());
        System.out.println(TransactionState.CANCELLED.ordinal());
        System.out.println(TransactionState.CANCELLED.toString());

//        Arrays.stream(TransactionState.values()).forEach(System.out::println);

        TransactionState cancelled = TransactionState.valueOf("CANCELLED");
        System.out.println(cancelled);


        System.out.println(Calculator.MUL.action(4, 5));

        System.out.println(Color.BLUE.getCode());
    }
}
