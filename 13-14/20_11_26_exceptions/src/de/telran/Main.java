package de.telran;

public class Main {

    static boolean toThrow = false;

    public static void main(String[] args) {
        methodA();

        toThrow = true;

        try {
            System.out.println("before method() call");
            methodA();
            System.out.println("after method() call");
        } catch (AUncheckedException e) {
            System.out.println("Under the first catch");
        } catch (Exception e) {
            System.out.println("Under the second catch");
            //usually here goes logging in the very end.
        }

        try {
            methodB();
        } catch (BCheckedException e) {
            System.out.println("under BChecked catch");
        } finally {
            System.out.println("under finally");
        }

        try {
            methodC();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("handled methodC with IndexOutOfBoundsException");
        }

        methodD();
    }

    static void methodA() {
        if (toThrow)
            throw new AUncheckedException();
    }

    /**
     * Here one can look through the description of the method
     *
     * @throws BCheckedException if lalala
     */
    static void methodB() throws BCheckedException {
        if (toThrow)
            throw new BCheckedException();
    }

    static void methodC() {
        try {
            methodA();
        } finally {
            throw new IndexOutOfBoundsException();
//            System.out.println("under second finally");
        }
    }

    static void methodD() {
        try {
            methodA();
        } catch (AUncheckedException aex) {
            throw new IndexOutOfBoundsException();
        } finally {
            throw new NullPointerException();
        }
    }
}
