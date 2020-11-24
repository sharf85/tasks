package de.telran;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SqrSolverTest {

    SqrSolver sqrSolver = new SqrSolver();

    @Test
    public void testSqr_nEquals1_1() {
        assertEquals(1, sqrSolver.sqr(1));
    }

    @Test
    public void testSqr_nEquals10_100() {
        assertEquals(100, sqrSolver.sqr(10));
    }

    @Test
    public void testSqr_nEquals13_169() {
        assertEquals(169, sqrSolver.sqr(13));
    }
}
