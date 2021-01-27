package de.telran;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    
    Solution solution = new Solution();
    
    @Test
    void getPrimes_1() {
        List<Integer> exp = Collections.singletonList(2);
        List<Integer> akt = solution.getPrimes(2);

        assertEquals(exp,akt);
    }

    @Test
    void getPrimes_2() {
        List<Integer> exp = Arrays.asList(2,3);
        List<Integer> akt = solution.getPrimes(4);

        assertEquals(exp,akt);
    }

    @Test
    void getPrimes_3() {
        List<Integer> exp = Arrays.asList(2,3,5);
        List<Integer> akt = solution.getPrimes(5);

        assertEquals(exp,akt);
    }
    @Test
    void getPrimes_4() {
        List<Integer> exp = Arrays.asList(2,3,5,7);
        List<Integer> akt = solution.getPrimes(9);

        assertEquals(exp,akt);
    }

    @Test
    void testGetPrimes_5() {
        List<Integer> exp = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
        List<Integer> akt = solution.getPrimes(30);

        assertEquals(exp, akt);
    }
}
