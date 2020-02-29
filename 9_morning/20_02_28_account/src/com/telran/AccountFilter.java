package com.telran;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class AccountFilter {

    /**
     * filters and returns a new list containing only those accounts which satisfy predicate
     *
     * @param accounts  list of accounts
     * @param predicate a rule deciding to leave the account or not
     * @return new list of filtered accounts
     */
    public List<Account> filter(List<Account> accounts, Predicate<Account> predicate) {
//        return accounts.stream().filter(predicate).collect(Collectors.toList());

        List<Account> res = new ArrayList<>();
        for (Account account : accounts) {
            if (predicate.test(account))
                res.add(account);
        }
        return res;
    }
}
