package de.telran;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution board = new Solution();

    @Test
    void board_NumberOfColumns_1() {
        int[] columnSum = {1};
        int[] rez = {1, 0};
        assertArrayEquals(rez, board.solve(columnSum, 1, 0));
    }

    @Test
    void board_NumberOfColumns_3() {
        int[] columnSum = {1, 0, 2};
        int[] expected = {1, 0, 1, 0, 0, 1};

        int[] res = board.solve(columnSum, 2, 1);

        assertArrayEquals(expected, res);
    }

    @Test
    void board_NumberOfColumns_6() {
        int[] columnSum = {1, 0, 2, 2, 0, 1};
        int[] expected = {1, 0, 1, 1, 0, 1, 0, 0, 1, 1, 0, 0};

        int[] res = board.solve(columnSum, 4, 2);

        assertArrayEquals(expected, res);
    }

    @Test
    void board_NumberOfColumns_5() {
        int[] columnSum = {2, 1, 1, 0, 1};

        int[] res = board.solve(columnSum, 3, 2);

        int p = 0;
        int q = 0;
        int[] resColumnSum = new int[5];

        for (int i = 0; i < columnSum.length; i++) {
            p += res[i];
            q += res[i + columnSum.length];
            resColumnSum[i] = res[i] + res[i + columnSum.length];
        }

        assertEquals(3, p);
        assertEquals(2, q);
        assertArrayEquals(columnSum, resColumnSum);

    }
}
