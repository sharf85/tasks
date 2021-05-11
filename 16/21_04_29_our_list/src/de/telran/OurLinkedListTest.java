package de.telran;

import org.junit.jupiter.api.BeforeEach;

class OurLinkedListTest extends OurListTest {

    @BeforeEach
    public void init() {
        integerList = new OurLinkedList<>();
        stringList = new OurLinkedList<>();
    }

}
