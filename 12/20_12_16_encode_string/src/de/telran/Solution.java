package de.telran;

/**
 * The problem of encoding a string. The string can contain only small letters
 */
public class Solution {

    public String solve(String string) {
        StringBuilder builder = new StringBuilder();

        int currentCharQty = 1;
        // we move through all the chars in the string from the second
        for (int i = 1; i < string.length(); i++) {
            // every time we check whether the current char coincides the prev one.
            // if it does, we increment the qty of the prev char
            // otherwise we saturate our result with the prev char and its qty
            if (string.charAt(i) == string.charAt(i - 1)) {
                currentCharQty++;
            } else {
                builder.append(string.charAt(i - 1));
                if (currentCharQty > 1) {
                    builder.append(currentCharQty);
                    currentCharQty = 1;
                }
            }
        }

        String ab = "a" + "b";
        // do not forget to add the last char and its qty in the string
        builder.append(string.charAt(string.length() - 1));
        if (currentCharQty > 1) {
            builder.append(currentCharQty);
        }

        return builder.toString();
    }
}
