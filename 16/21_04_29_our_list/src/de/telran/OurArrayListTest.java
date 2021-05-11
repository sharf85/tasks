package de.telran;

import org.junit.jupiter.api.BeforeEach;

class OurArrayListTest extends OurListTest {

    @BeforeEach
    public void init() {
        integerList = new OurArrayList<>();
        stringList = new OurArrayList<>();
    }

}
