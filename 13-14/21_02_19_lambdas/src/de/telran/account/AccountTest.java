package de.telran.account;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    Predicate<Account> positiveBalance = account -> account.getBalance() > 0;
    Predicate<Account> majorPredicate = account -> account.getBalance() > 100_000 && !account.isLocked();
    AccountFilter filter = new AccountFilter();

    Account one = new Account("1", 0, false);
    Account two = new Account("2", 0, true);
    Account three = new Account("3", 1, false);
    Account four = new Account("4", 1, true);
    Account five = new Account("5", 100000, false);
    Account six = new Account("6", 100000, true);
    Account seven = new Account("7", 99999, false);
    Account eight = new Account("8", 99999, true);
    Account nine = new Account("9", 100001, false);
    Account ten = new Account("10", 100001, true);
    List<Account> test = Arrays.asList(one, two, three, four, five, six, seven, eight, nine, ten);

    @Test
    public void test_emptyList() {
        List<Account> list = new ArrayList<>();
        assertTrue(filter.filter(list, positiveBalance).isEmpty());
        assertTrue(filter.filter(list, majorPredicate).isEmpty());
    }

    @Test
    public void test_positiveBalance() {
        List<Account> expected = Arrays.asList(three, four, five, six, seven, eight, nine, ten);
        assertEquals(expected, filter.filter(test, positiveBalance));
    }

    @Test
    public void test_majorPredicate() {
        List<Account> expected = Collections.singletonList(nine);
        assertEquals(expected, filter.filter(test, majorPredicate));
    }
}
