package de.telran;

import org.junit.jupiter.api.BeforeEach;

class OurTreeMapTest extends OurMapTest {

    @BeforeEach
    public void init() {
        map = new OurTreeMap<>();
        intMap = new OurTreeMap<>();
    }
}
