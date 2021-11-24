package de.telran;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // write your code here
        String string3 = new String("Hello world");
        // constructor from char array
        String stringFromChars = new String(new char[]{'H', 'e', 'l', 'l', 'o', ' ', 'w', 'o', 'r', 'l', 'd'});
        String string = "Hello world";
        String string2 = "Hello world";

        System.out.println(string == string2);//true
        System.out.println(string == string3);//false
        System.out.println(string == stringFromChars);//false
        System.out.println(string3 == stringFromChars);//false

        System.out.println(string.equals(string2));//true
        System.out.println(string.equals(string3));//true
        System.out.println(string.equals(stringFromChars));//true
        System.out.println(string3.equals(stringFromChars));//true

        // char
        char a = 'a';
        System.out.println(a);//'a'
        System.out.println(a + 0);//97
        System.out.println(string + a);//Hello worlda
        System.out.println(string + a + 0);//Hello worlda0

        // charAt() -> char
        System.out.println(string.charAt(2));//'l'

        // concat -> str
        System.out.println(string.concat(" ").concat(string2));// Hello worldHello world
        System.out.println(string + string2);// Hello worldHello world

        // contains() -> boolean
        System.out.println(string.contains("llo"));//true

        // startsWith(), endsWith() -> boolean
        System.out.println(string.startsWith("Hell"));

        // equalsIgnoreCase() -> boolean
        String hello1 = "HeLlO";
        String hello2 = "hellO";
        System.out.println(hello1.equalsIgnoreCase(hello2));//true

        // indexOf() -> int - returns the first index of the pattern in the string
        System.out.println(string.indexOf("lo"));//3
        System.out.println(string.indexOf("llo"));//2
        System.out.println(string.indexOf("l", 4));//9

        // lastIndexOf() -> int - returns the last index of the pattern
        System.out.println(string.lastIndexOf("l"));//9
        System.out.println(string.lastIndexOf("l", 8));//3

        // length() -> int
        System.out.println(string.length());//11

        // split() -> String[]
        String[] fromString = string.split("l");
        System.out.println(Arrays.toString(fromString));
        System.out.println(Arrays.toString(string.split(" ")));

        // toCharArray() -> char[]
        char[] chars = string.toCharArray();// {'H', 'e', 'l', 'l', 'o', ' ', 'w', 'o', 'r', 'l', 'd'}
        System.out.println(Arrays.toString(chars));

        // toLowerCase(), toUpperCase() -> String
        String upperString = string.toUpperCase();
        System.out.println(string);
        System.out.println(upperString);

        // substring() -> String, the second argument, which is the index of the end, applies exclusively
        String substring1 = string.substring(2);// llo world
        String substring2 = string.substring(2, 8);// llo wo
        System.out.println(substring1);
        System.out.println(substring2);

        // reverse()
        System.out.println(reverse(string));
        System.out.println(reverse2(string));
    }

    static String reverse(String str) {
        char[] chars = new char[str.length()];

        for (int i = 0; i < chars.length; i++) {
            chars[i] = str.charAt(chars.length - 1 - i);
        }

        return new String(chars);
    }

    // very slow variant
    static String reverse2(String str) {
        String res = "";

        for (int i = 0; i < str.length(); i++) {
            res += str.charAt(str.length() - 1 - i);
        }

        return res;
    }
}
