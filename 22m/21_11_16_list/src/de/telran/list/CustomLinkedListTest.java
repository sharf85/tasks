package de.telran.list;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class CustomLinkedListTest extends CustomListTest {
    @BeforeEach
    public void init() {
        intList = new CustomLinkedList<>();
        stringList = new CustomLinkedList<>();
    }
}
