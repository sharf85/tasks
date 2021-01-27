package de.telran;

public class Solution {

    /**
     * the method recovers the board 2*n
     *
     * @param columns sums in each column
     * @param p       sum in the first row
     * @param q       sum in the second row
     * @return recovered board
     */
    public int[] solve(int[] columns, int p, int q) {
        int width = columns.length;

        int[] res = new int[width * 2];

        for (int columnNumber = width - 1; columnNumber >= 0; columnNumber--) {
            int columnSum = columns[columnNumber];
            if (columnSum == 0) {
                res[columnNumber] = res[columnNumber + width] = 0;
            } else if (columnSum == 2) {
                res[columnNumber] = res[columnNumber + width] = 1;
                p--;
                q--;
            } else if (p > q) {
                res[columnNumber] = 1;
                res[columnNumber + width] = 0;
                p--;
            } else {
                res[columnNumber] = 0;
                res[columnNumber + width] = 1;
                q--;
            }
        }

        return res;
    }
}
