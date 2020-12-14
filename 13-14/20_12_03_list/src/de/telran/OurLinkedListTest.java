package de.telran;

import org.junit.jupiter.api.BeforeEach;

public class OurLinkedListTest extends OurListTest {
    @BeforeEach
    public void init() {
        list = new OurLinkedList<>();
        stringList = new OurLinkedList<>();
    }
}
