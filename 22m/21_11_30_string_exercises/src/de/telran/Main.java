package de.telran;

public class Main {

    public static void main(String[] args) {
        System.out.println(isPalindrome("helleh"));
        System.out.println(isPalindrome("helle"));

        System.out.println(countPattern("aaabcbcbcddd", "bc"));//3
        System.out.println(countPattern("aaabcbcbcddd", "bcbc"));//2

        System.out.println(cutString("hello world guys", 0));// ""

        System.out.println(cutString("hello world guys", 4));// ""
        System.out.println(cutString("hello world guys", 5));// "hello"
        System.out.println(cutString("hello world guys", 6));// "hello"
        System.out.println(cutString("hello world guys", 7));// "hello"

        System.out.println(cutString("hello world guys", 10));// "hello"
        System.out.println(cutString("hello world guys", 11));// "hello world"
        System.out.println(cutString("hello world guys", 12));// "hello world"
        System.out.println(cutString("hello world guys", 13));// "hello world"

        System.out.println(cutString("hello world guys", 16));// "hello world guys"
        System.out.println(cutString("hello world guys", 17));// "hello world guys"
    }

    static boolean isPalindrome(String str) {
        String reversed = reverse(str);
        return reversed.equalsIgnoreCase(str);
    }

    static int countPattern(String str, String pattern) {
        int count = 0;
        int index = str.indexOf(pattern);

        while (index > -1) {
            count++;
            index++;
            index = str.indexOf(pattern, index);
        }

        return count;
    }

    static String cutString(String str, int n) {
        if (n >= str.length())
            return str;

        String cut = str.substring(0, n + 1);

        int lastSpaceIndex = cut.lastIndexOf(" ");
        if (lastSpaceIndex < 0)
            return "";

        return cut.substring(0, lastSpaceIndex);
    }

    static String reverse(String str) {
        char[] chars = new char[str.length()];

        for (int i = 0; i < chars.length; i++) {
            chars[i] = str.charAt(chars.length - 1 - i);
        }

        return new String(chars);
    }
}
