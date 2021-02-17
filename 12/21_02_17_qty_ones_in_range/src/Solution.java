import java.util.stream.IntStream;

public class Solution {

    /**
     * The method returns the qty of numbers containing the digit between a and b inclusive.
     * a must be lower or equals b.
     *
     * @param a
     * @param b
     * @param digit - must be a int number from 0 to 9 inclusive
     * @return
     */
    public int solve(int a, int b, int digit) {
        int res = 0;
        for (int i = a; i <= b; i++) {
            if (containsDigitRecursive(Math.abs(i), digit))
                res++;
        }
        return res;
    }

//    public int solve(int a, int b, int digit) {
//        return (int) IntStream.rangeClosed(a, b)
//                .filter(value -> containsDigit(value, digit))
//                .count();
//    }

    private boolean containsDigit(int number, int digit) {
        String stringNumber = String.valueOf(number);
        String stringDigit = String.valueOf(digit);

        return stringNumber.contains(stringDigit);
    }


    /**
     * the method determines whether the 'number' contains the 'digit'
     *
     * @param number must be non negative
     * @param digit  a int number from 0 to 9
     * @return
     */
    private boolean containsDigitRecursive(int number, int digit) {
        if (number < 10)
            return digit == number;

        int rest = number % 10;
        if (rest == digit)
            return true;
        else
            return containsDigitRecursive(number / 10, digit);
    }


}
