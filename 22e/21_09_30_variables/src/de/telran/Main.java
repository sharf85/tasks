package de.telran;

public class Main {

    public static void main(String[] args) {
        int a;// declaration
        a = 0;// initialization

        System.out.println(a);

        int b = 5;
        b = 90;

        a = -10;
        System.out.println(a);
        System.out.println(b);

        // 2531 (7)
        int number = 2 * 7 * 7 * 7 + 5 * 7 * 7 + 3 * 7 + 1;
        System.out.println(number);

        byte byte1 = 7;
        short short1 = 239;
        int someInt = short1 * byte1;
        int anotherInt = byte1 + byte1;

        long long1 = 400;
        long long2 = long1 + someInt;

        int integer = 200 + 300;

        byte maxByte = 127;
        int maxBytePlus1 = maxByte + 1;

        System.out.println(maxBytePlus1);

        System.out.println(Integer.MAX_VALUE);

        short maxByteInShort = 128;
        byte downcastedByte = (byte) maxByteInShort;
        System.out.println(downcastedByte);

        byte minByte = -128;
        short minByteInShort = minByte;
        System.out.println(minByteInShort);

        // arithmetical operations (+-*/)
        int afterDivision = 10 / 3;// 3
        // 11/3 -> 3
        // 12/3 -> 4

        int remainderAfterDivision = 10 % 3;// 1
        // 11 % 3 -> 2
        // 12 % 3 -> 0
        // -10 % 3 -> -1

        int c = 10;
        c = c + 5;//15
        c += 5;//20

        c = a + c;//10
        System.out.println(c);

        c *= 10;//100
        System.out.println(c);

        c++;// c = c + 1 // c += 1
        ++c;//102

        c--;
        --c;//100

        System.out.println(c);
    }
}
