package de.telran;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.partitioningBy;

public class PalindromeService {

    public boolean isPalindrome(String str) {
        StringBuilder builder = new StringBuilder(str);
        String reversedString = builder.reverse().toString();
        return str.equals(reversedString);
    }

    public Map<Boolean, List<String>> splitByPalindromeFactor(List<String> strings) {
        return strings.stream()
                .collect(partitioningBy(this::isPalindrome));
    }
}
