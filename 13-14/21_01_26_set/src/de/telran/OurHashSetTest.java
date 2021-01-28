package de.telran;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class OurHashSetTest extends OurSetTest {
    @BeforeEach
    public void init() {
        set = new OurHashSet<>();
        another = new OurHashSet<>();
    }
}
