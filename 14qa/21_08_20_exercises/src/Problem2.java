public class Problem2 {

    /**
     * The method should receive a string and invert the case of letters
     *
     * @param str not null
     * @return
     */
    public String solve(String str) {
        char[] chars = str.toCharArray();
        char[] res = new char[chars.length];

        for (int i = 0; i < chars.length; i++) {
            char current = chars[i];

            if (Character.isLowerCase(current))
                res[i] = Character.toUpperCase(current);
            else
                res[i] = Character.toLowerCase(current);
        }

        return new String(res);
    }
}
