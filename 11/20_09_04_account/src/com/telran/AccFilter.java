package com.telran;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class AccFilter {

    public List<Account> filter(List<Account> accounts, Predicate<Account> pred) {
        List<Account> res = new ArrayList<>();

        for (Account account : accounts) {
            if (pred.test(account))
                res.add(account);
        }

        return res;
    }
}
