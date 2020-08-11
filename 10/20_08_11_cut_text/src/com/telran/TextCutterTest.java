package com.telran;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TextCutterTest {

    TextCutter cutter = new TextCutter();

    @Test
    public void testMakeText_HelloWorldAndN11_HelloWorld() {
        String s = "Hello world";
        assertEquals("Hello world", cutter.cut(s, 11));
    }

    @Test
    public void testMakeText_HelloWorldAndN5_Hello() {
        String s = "Hello world";
        assertEquals("Hello", cutter.cut(s, 5));
    }

    @Test
    public void testMakeText_HelloWorldAndN6_Hello() {
        String s = "Hello world";
        assertEquals("Hello", cutter.cut(s, 6));
    }

    @Test
    public void testMakeText_HelloWorldAndN7_Hello() {
        String s = "Hello world";
        assertEquals("Hello", cutter.cut(s, 7));
    }

    @Test
    public void testMakeText_HelloWorldAndN4_emptyString() {
        String s = "Hello world";
        assertEquals("", cutter.cut(s, 4));
    }

    @Test
    public void testMakeText_HelloWorlAndYoudAndN17_emptyString() {
        String s = "Hello world and you!";
        assertEquals("Hello world and", cutter.cut(s, 17));
    }
}
