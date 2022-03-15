package de.telran;

public class MoneyChanger {

    public int recursiveChange(int money, int[] coins) {
        if (money == 0)
            return 0;

        int res = Integer.MAX_VALUE;

        for (int coin : coins) {
            int moneySubtask = money - coin;

            if (moneySubtask >= 0) {
                int intermediateRes = recursiveChange(moneySubtask, coins) + 1;
                if (res > intermediateRes)
                    res = intermediateRes;
            }
        }

        return res;
    }

    public int DPChange(int money, int[] coins) {
        int[] results = new int[money + 1];

        results[0] = 0;
        for (int i = 1; i <= money; i++) {
            results[i] = Integer.MAX_VALUE;

            for (int coin : coins) {
                int prevSum = i - coin;
                if (prevSum >= 0) {
                    int possibleRes = results[prevSum] + 1;
                    if (possibleRes < results[i])
                        results[i] = possibleRes;
                }
            }
        }

        return results[money];
    }
}
