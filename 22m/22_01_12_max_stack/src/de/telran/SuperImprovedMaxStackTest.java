package de.telran;

import org.junit.jupiter.api.BeforeEach;

class SuperImprovedMaxStackTest extends MaxStackTest {

    @BeforeEach
    public void init() {
        maxStack = new SuperImprovedMaxStack();
    }

}
