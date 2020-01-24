package com.telran;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepeatedNumbers {

    public int getQtyRepeatedNumbers(List<Integer> list) {
        Map<Integer, Integer> qtyByNumber = new HashMap<>();

        for (int num : list) {
//            qtyByNumber.compute(num, (key, oldVal) -> {
//                return oldVal + 1;
//            });

            if (qtyByNumber.containsKey(num)) {
                int val = qtyByNumber.get(num);
                val++;
                qtyByNumber.put(num, val);
            } else {
                qtyByNumber.put(num, 1);
            }
        }

        int res = 0;
        for (int num : qtyByNumber.keySet()) {
            if (qtyByNumber.get(num) > 1)
                res++;
        }
        return res;
    }
}
