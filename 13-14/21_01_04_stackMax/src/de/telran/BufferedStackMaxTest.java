package de.telran;

import org.junit.jupiter.api.BeforeEach;

class BufferedStackMaxTest extends StackMaxTest {

    @BeforeEach
    public void init() {
        myStack = new BufferedStackMax<>(new IntegerBasicComparator());
    }
}
