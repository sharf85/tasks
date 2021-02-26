package de.telran;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class PalindromeServiceTest {

    PalindromeService listService = new PalindromeService();

    @Test
    void verify() {
        List<String> list = Arrays.asList("ehe", "aha", "ufo", "sort");
        Map<Boolean, List<String>> res = listService.splitByPalindromeFactor(list);
        List<String> listTrue = Arrays.asList("ehe", "aha");
        List<String> listFalse = Arrays.asList("ufo", "sort");
        assertEquals(listTrue, res.get(true));
        assertEquals(listFalse, res.get(false));
    }

    @Test
    void verify_onlyTrue() {
        List<String> list = Arrays.asList("городурвамаврудорог", "удубабуду");
        Map<Boolean, List<String>> res = listService.splitByPalindromeFactor(list);
        List<String> listTrue = Arrays.asList("городурвамаврудорог", "удубабуду");
        List<String> listFalse = Collections.emptyList();
        assertEquals(listTrue, res.get(true));
        assertEquals(listFalse, res.get(false));
    }

    @Test
    public void palindromFilter_test1() {
        List<String> list = Arrays.asList("heh", "hello", "hi", "level", "madam", "sir",
                "noon", "twenty");
        Map<Boolean, List<String>> res = new HashMap<>();
        res.put(false, Arrays.asList("hello", "hi", "sir", "twenty"));
        res.put(true, Arrays.asList("heh", "level", "madam", "noon"));

        assertEquals(res, listService.splitByPalindromeFactor(list));
    }
}
