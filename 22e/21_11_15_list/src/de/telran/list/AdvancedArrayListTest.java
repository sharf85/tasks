package de.telran.list;

import org.junit.jupiter.api.BeforeEach;

class AdvancedArrayListTest extends CustomListTest {
    @BeforeEach
    public void init() {
        intList = new AdvancedArrayList<>(0);
        stringList = new AdvancedArrayList<>(0);
    }
}
