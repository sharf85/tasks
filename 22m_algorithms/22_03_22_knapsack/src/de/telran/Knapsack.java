package de.telran;

public class Knapsack {

    // Есть рюкзак объемом V. Есть набор из N предметов, у каждого объем v_i, стоимость p_i. Найти максимальную стоимость
// предметов, которые можно уместить в рюкзаке.

// Пусть у нас есть решение задачи для рюкзака объема V и набора предметов 0 - (N-1).
// Тогда, в нем либо есть предмет с нулевым индексом, либо нету.
// 1. Пусть есть.
// Тогда, если этот предмет убрать из решения, то оставшиеся предметы составят решение к задаче с объемом рюкзака V - v0
// и набором предметов от 1го до N-1 предмета.
// 2. Пусть нет.
// Тогда, решение исходной задачи сводится к решению задачи с рюкзаком того же объема, но набор предметов от 1го до (N-1)го.

// Пример. Есть рюкзак объемом 10. Есть предметы (6, 30$), (3, 14$), (4, 16$), (2, 9$)

    public int solveWORepetitions(int knapsackV, int[] volumes, int[] prices) {
        // res[i][j] - это решение к задаче рюкзака объема i и набора первых j предметов
        int[][] res = new int[knapsackV + 1][volumes.length + 1];

        for (int i = 1; i <= knapsackV; i++) {
            for (int j = 1; j <= volumes.length; j++) {
                res[i][j] = res[i][j - 1];

                if (i >= volumes[j - 1]) {
                    int possibleRes = res[i - volumes[j - 1]][j - 1] + prices[j - 1];

                    if (possibleRes > res[i][j])
                        res[i][j] = possibleRes;
                }
            }
        }

        return res[knapsackV][volumes.length];
    }

    // Рюкзак с повторениями.
    // Пусть есть решение для рюкзака объема V. Тогда, убрав из рюкзака любой предмет, мы получим решение для
    // рюкзака объема V - v, где v - это объем убранного предмета.

    // Рассмотрим решения для каждой из задач для рюкзака объемами V - v_i, где v_i - объемы имеющихся предметов.
    // тогда решение задачи с рюкзаком объема V будет максимум из решений для рюкзака объемом V - v_i плюс стоимость
    // i-ой вещи.

    // res[V] = max(res[V - v_i] + p_i)


    public int solveWRepetitions(int knapsackV, int[] volumes, int[] prices) {
        // решение задачи для объемов рюкзака от 0 до knapsackV
        int[] res = new int[knapsackV + 1];

        for (int i = 1; i <= knapsackV; i++) {
            for (int j = 0; j < volumes.length; j++) {
                int lightenedKnapsack = i - volumes[j];
                if (lightenedKnapsack >= 0) {
                    int possibleRes = res[lightenedKnapsack] + prices[j];
                    if (res[i] < possibleRes)
                        res[i] = possibleRes;
                }
            }
        }

        return res[knapsackV];
    }

    public int solveWRepetitionsRecursively(int knapsackV, int[] volumes, int[] prices) {
        // решение задачи для объемов рюкзака от 0 до knapsackV

        if (knapsackV == 0)
            return 0;

        int res = 0;

        for (int i = 0; i < volumes.length; i++) {
            if (knapsackV >= volumes[i]) {
                int possibleRes = solveWRepetitionsRecursively(knapsackV - volumes[i], volumes, prices) + prices[i];
                if (res <= possibleRes)
                    res = possibleRes;
            }

        }

        return res;
    }
}
