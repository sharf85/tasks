package de.telran.account;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class AccountFilter {
    public List<Account> filter(List<Account> accounts, Predicate<Account> predicate) {
        List<Account> res = new ArrayList<>();

        for (Account account : accounts) {
            if (predicate.test(account))
                res.add(account);
        }

        return res;

//        return accounts.stream()
//                .filter(predicate)
//                .collect(Collectors.toList());
    }
}
