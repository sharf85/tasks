package de.telran;

import org.junit.jupiter.api.BeforeEach;

class NaiveMaxElementStackTest extends IMaxElementStackTest {
    @BeforeEach
    void setUp() {
        maxElementStack = new NaiveMaxElementStack<>();//создаю
    }
}
