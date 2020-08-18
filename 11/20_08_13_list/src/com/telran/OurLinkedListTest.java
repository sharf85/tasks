package com.telran;

import org.junit.jupiter.api.BeforeEach;

class OurLinkedListTest extends OurListTest {
    @BeforeEach
    void init() {
        list = new OurLinkedList<>();
        pointList = new OurLinkedList<>();
    }
}
