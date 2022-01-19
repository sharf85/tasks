package de.telran;

import org.junit.jupiter.api.BeforeEach;

class NaiveMaxStackTest extends MaxStackTest {

    @BeforeEach
    public void init() {
        maxStack = new NaiveMaxStack();
    }

}
