package de.telran;

import java.util.Arrays;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        char[] chars = {'H', 'e', 'l', 'l', 'o', ' ', 'w', 'o', 'r', 'l', 'd'};

        String helloWorld = new String(chars);
        System.out.println(helloWorld);

        String str = "Hello world";
        String str2 = "Hello world";

        System.out.println(str == str2);//true
        System.out.println(helloWorld == str);//false


        // charAt() -> char
        System.out.println(helloWorld.charAt(4));//o
        // concat() instead of +
        System.out.println(helloWorld.concat(" ").concat(str));//Hello world Hello world
        // contains() -> boolean
        System.out.println(str.contains("a"));//false
        // endsWith() -> boolean
        System.out.println(str.endsWith("world"));//true
        // startsWith() -> boolean
        //the same
        // equals(Object str2) -> boolean
        System.out.println(str.equals(str2));//true
        System.out.println(helloWorld.equals(str2));//true
        // equalsIgnoreCase(String) -> boolean
        System.out.println("Hello".equalsIgnoreCase("HeLlO"));
        // indexOf() -> int
        System.out.println(str.indexOf('l'));//2
        System.out.println(str.indexOf('l', 3));//3
        System.out.println(str.indexOf("l", 4));//9
        System.out.println(str.indexOf("world"));//6
        // lastIndexOf() -> int
        System.out.println(str.lastIndexOf('l'));//9
        // length() -> int
        System.out.println(str.length());//11
        // split() -> String[]
        System.out.println(Arrays.toString(str.split("l")));
        // toCharArray() -> char[]
        System.out.println(Arrays.toString(str.toCharArray()));
        // toLowerCase() -> String
        System.out.println(str.toLowerCase());
        // toUpperCase() -> String
        System.out.println(str.toUpperCase());
        // substring() -> String

        System.out.println(str.substring(6));
        System.out.println(str.substring(0, 5));

        System.out.println(reverse(str));
        System.out.println(reverse2(str));
    }

    static String reverse(String str) {
        char[] chars = str.toCharArray();
        char[] newChars = new char[chars.length];

        for (int i = 0; i < chars.length; i++) {
            newChars[i] = chars[chars.length - i - 1];
        }

        return new String(newChars);
    }

    static String reverse2(String str) {
        String res = "";

        for (int i = 0; i < str.length(); i++) {
            res += str.charAt(str.length() - 1 - i);
        }

        return res;
    }
}
