package de.telran;

public class StringService {

    /**
     * The method returns reversed string.
     *
     * @param text - string to reverse. The argument must not be null. Otherwise the behavior is
     *             undefined.
     * @return reversed string
     */
    public String reverse(String text) {
//        StringBuilder builder = new StringBuilder(text);
//        return builder.reverse().toString();
        char[] chars = text.toCharArray();

        int length = chars.length;
        for (int i = 0; i < length / 2; i++) {// n/2 iterations, 10 operations each=> summary ~5n operations O(n)
            char temp = chars[i];
            chars[i] = chars[length - i - 1];
            chars[length - i - 1] = temp;
        }
        return new String(chars);
    }
}
