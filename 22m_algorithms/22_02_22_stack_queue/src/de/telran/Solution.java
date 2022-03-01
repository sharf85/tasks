package de.telran;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    /**
     * Метод принимает массив, состоящий из трех видов скобок (6 различных символов): (), {}, []. Необходимо определить, является
     * ли порядок скобок в массиве корректным.
     * <p>
     * {}([]) - корректный порядок
     * {}([]{()}) - корректный порядок
     * {(] - некорректный порядок
     * {}([])} - некорректный порядок
     * {}([])( - некорректный порядок
     * {(}) - некорректный порядок
     *
     * @param brackets
     * @return
     */

    // необходимо использовать стек для хранения открытых в данный момент скобок.
    public boolean areBracketsCorrect(char[] brackets) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char bracket : brackets) {
            if (bracket == '{' || bracket == '(' || bracket == '[') {
                stack.addLast(bracket);
            } else if (stack.size() > 0) {
                char lastOpenBracket = stack.getLast();

                if (bracket == '}' && lastOpenBracket == '{' ||
                        bracket == ')' && lastOpenBracket == '(' ||
                        bracket == ']' && lastOpenBracket == '[')
                    stack.removeLast();
                else
                    return false;
            } else {
                return false;
            }
        }

        return stack.size() == 0;
    }

    // В ретсторан периодически попадает заказ. У заказа есть время, когда он был сделан (milliseconds from 1970 1 Jan, UTC).
    // Для каждого заказа необходимо установить количество заказов, сделанных за 15 (20, N) минут до него.

    /**
     * @param orderTimes - массив отсортированных по времени моментов, когда происходили заказы.
     * @param minutes
     * @return для соответствующиего заказа - количество заказов, сделанных в предыдущие minutes минут
     */
    public int[] countOrdersNumber(long[] orderTimes, int minutes) {
        int[] res = new int[orderTimes.length];
        Deque<Long> queue = new ArrayDeque<>();
        long millis = minutes * 60L * 1000;

        int i = 0;
        for (long orderTime : orderTimes) {
            queue.addLast(orderTime);
            while (orderTime - queue.getFirst() > millis)
                queue.removeFirst();

            res[i++] = queue.size() - 1;
        }

        return res;
    }


}
