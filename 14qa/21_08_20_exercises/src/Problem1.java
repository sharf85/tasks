public class Problem1 {

    /**
     * The method should receive a string, reverse it and return the result
     *
     * @param str any string but not null
     * @return
     */
    public String solve(String str) {
//        StringBuilder sb = new StringBuilder(str);
//        return sb.reverse().toString();

        char[] chars = str.toCharArray();

        int middleIndex = chars.length / 2;
        for (int i = 0; i < middleIndex; i++) {
            char temp = chars[i];
            chars[i] = chars[chars.length - 1 - i];
            chars[chars.length - 1 - i] = temp;
        }
        return new String(chars);
    }
}
