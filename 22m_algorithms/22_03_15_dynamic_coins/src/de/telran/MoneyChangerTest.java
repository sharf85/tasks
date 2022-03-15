package de.telran;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoneyChangerTest {

    MoneyChanger changer = new MoneyChanger();

    @Test
    public void testRecursiveChange_zero_zero() {
        int[] coins = {1, 7, 10};

        assertEquals(0, changer.recursiveChange(0, coins));
    }

    @Test
    public void testRecursiveChange_6_6() {
        int[] coins = {1, 7, 10};

        assertEquals(6, changer.recursiveChange(6, coins));
    }


    @Test
    public void testRecursiveChange_7_1() {
        int[] coins = {1, 7, 10};

        assertEquals(1, changer.recursiveChange(7, coins));
    }

    @Test
    public void testRecursiveChange_14_2() {
        int[] coins = {10, 7, 1};

        assertEquals(2, changer.recursiveChange(14, coins));
    }

    @Test
    public void testDPChange_zero_zero() {
        int[] coins = {1, 7, 10};

        assertEquals(0, changer.DPChange(0, coins));
    }

    @Test
    public void testDPChange_6_6() {
        int[] coins = {1, 7, 10};

        assertEquals(6, changer.DPChange(6, coins));
    }


    @Test
    public void testDPChange_7_1() {
        int[] coins = {1, 7, 10};

        assertEquals(1, changer.DPChange(7, coins));
    }

    @Test
    public void testDPChange_14_2() {
        int[] coins = {10, 7, 1};

        assertEquals(2, changer.DPChange(14, coins));
    }

}
