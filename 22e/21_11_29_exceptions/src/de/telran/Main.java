package de.telran;

public class Main {

    public static void main(String[] args) {

        int a = 6;
        int b = 2;

        try {
            int res = intDiv2Wrapper(a, b);
            System.out.println(res);
            System.out.println("After division");
        } catch (CustomArithmeticException e) {
            System.out.println("inside catch Arithmetic exception");
        } catch (RuntimeException e) {
            System.out.println("inside catch");
        } finally {
            System.out.println("inside finally");
        }
    }

    /**
     * the method returns the result of int division a over b
     *
     * @param a
     * @param b
     * @return
     */
    static int intDiv(int a, int b) {
        int res = a / b;
        return res;
    }

    /**
     * The method divides a over b
     *
     * @param a
     * @param b
     * @return
     * @throws CustomArithmeticException if b equals 0
     */
    static int intDiv2(int a, int b) {
        if (b == 0)
            throw new CustomArithmeticException();

        int res = a / b;
        return res;
    }

    static int intDiv2Wrapper(int a, int b) {
        int res = intDiv2(a, b);
        return res;
    }
}
