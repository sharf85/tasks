package de.telran;

public class Main {

    public static void main(String[] args) {
        PairwiseProblem pairwiseProblem = new PairwiseProblem();

        System.out.println(pairwiseProblem.solve(new int[]{1, 2}));//2
        System.out.println(pairwiseProblem.solve(new int[]{1, 10, 2}));//20
        System.out.println(pairwiseProblem.solve(new int[]{100_000, 100_000}));//10_000_000_000
        System.out.println(pairwiseProblem.solve(new int[]{0, 100_000}));//0
    }
}
