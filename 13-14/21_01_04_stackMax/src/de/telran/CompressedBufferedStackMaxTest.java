package de.telran;

import org.junit.jupiter.api.BeforeEach;

class CompressedBufferedStackMaxTest extends StackMaxTest {
    @BeforeEach
    public void init() {
        myStack = new CompressedBufferedStackMax<>(new IntegerBasicComparator());
    }
}
