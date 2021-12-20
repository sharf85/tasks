package de.telran.list;

import org.junit.jupiter.api.BeforeEach;

class CustomLinkedListTest extends CustomListTest {

    @BeforeEach
    public void init() {
        intList = new CustomLinkedList<>();
        stringList = new CustomLinkedList<>();
    }
}
