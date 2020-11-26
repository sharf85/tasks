import java.util.Arrays;

public class Solution {

    /**
     * The method reverses the text and then returns
     *
     * @param text - the string to reverse
     * @return reversed text
     */
    public String reverse(String text) {
        StringBuilder builder = new StringBuilder(text);
        builder.reverse();
        return builder.toString();
    }
}
