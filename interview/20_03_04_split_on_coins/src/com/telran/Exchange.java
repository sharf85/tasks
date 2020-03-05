package com.telran;

import java.util.*;

public class Exchange {

    private Set<Integer> coins;

    public Exchange(Collection<Integer> coins) {
        this.coins = new HashSet<>(coins);
    }

    public List<Integer> split(int sum) {
        List<Integer> res = new ArrayList<>();

        Deque<Integer> currentSplit = new ArrayDeque<>();
        rSplit(sum, currentSplit, res);
        return res;
    }

    private void rSplit(int sum, Deque<Integer> currentSplit, List<Integer> res) {
        if (sum == 0) {
            if (res.size() == 0 || (res.size() > currentSplit.size())) {
                res.clear();
                res.addAll(currentSplit);
            }
            return;
        }

        for (int coin : coins) {
            if (coin <= sum) {
                currentSplit.addLast(coin);
                rSplit(sum - coin, currentSplit, res);
                currentSplit.removeLast();
            }
        }
    }
}
