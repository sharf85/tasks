package com.telran;

import org.junit.jupiter.api.BeforeEach;

class OurArrayListTest extends OurListTest {
    @BeforeEach
    void init() {
        list = new OurArrayList<>();
        pointList = new OurArrayList<>();
    }
}
