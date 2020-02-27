package com.telran;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class DictionaryTest {

    @Test
    public void testIsBookContainRecursive_Equals_true() {
        Set<String> dictionary = new HashSet<>(Arrays.asList("who", "are", "you"));

        Dictionary ourDictionary = new Dictionary(dictionary);
        String text = "whoareyou";

        Deque<String> expected = new ArrayDeque<>(Arrays.asList("who", "are", "you"));
        Deque<String> result = new ArrayDeque<>(ourDictionary.split(text));

        assertArrayEquals(expected.toArray(), result.toArray());
    }

    @Test
    public void testIsBookContainRecursive_NonEquals_false() {

        Set<String> dictionary = new HashSet<>(Arrays.asList("mu", "tex", "call"));

        Dictionary ourDictionary = new Dictionary(dictionary);
        String text = "texcalll";
        assertNull(ourDictionary.split(text));
    }

    @Test
    public void testIsBookContainRecursive_EqualsWithSameWord_true() {
        Set<String> dictionary = new HashSet<>();
        String word01 = "mu";
        dictionary.add(word01);
        Dictionary ourDictionary = new Dictionary(dictionary);
        String text = "mumu";
        Deque<String> expected = new ArrayDeque<>();
        expected.addLast(word01);
        expected.addLast(word01);
        Deque<String> result = new ArrayDeque<>(ourDictionary.split(text));
        for (int i = 0; i < result.size(); i++) {
            assertTrue(expected.getFirst().equals(result.getFirst()));
        }
    }

    @Test
    public void testIsBookContainRecursive_EqualsWithDifferentWords_true() {
        Set<String> dictionary = new HashSet<>(Arrays.asList("mu", "tex", "call"));

        Dictionary ourDictionary = new Dictionary(dictionary);
        String text = "texcall";
        Deque<String> expected = new ArrayDeque<>(Arrays.asList("tex", "call"));

        assertArrayEquals(expected.toArray(), ourDictionary.split(text).toArray());

    }

    @Test
    public void testIsBookContainRecursive_EqualsWithDifferentAndSameWords_true() {
        Set<String> dictionary = new HashSet<>(Arrays.asList("mu", "tex", "call"));

        Dictionary ourDictionary = new Dictionary(dictionary);
        String text = "calltexcall";
        Deque<String> expected = new ArrayDeque<>(Arrays.asList("call", "tex", "call"));

        assertArrayEquals(expected.toArray(), ourDictionary.split(text).toArray());
    }

    @Test
    public void testIsWordsInDictionary_wordsInDict_true() {
        String text = "mynameismy";
        List<String> dict = Arrays.asList("name", "is", "my");
        Dictionary wordsInDictionary = new Dictionary(dict);
        assertNotNull(wordsInDictionary.split(text));
    }
    @Test
    public void test1() {
        String text = "tymyt";
        List<String> dict = Arrays.asList("myt", "mym", "yt", "Hello");
        Dictionary wordsInDictionary = new Dictionary(dict);
        assertNull(wordsInDictionary.split(text));
    }
    @Test
    public void testIsWordsNotInDictionary_wordsInDict_true() {
        String text = "sdfkdk.jfdjkg";
        List<String> dict = Arrays.asList("name", "is", "my");
        Dictionary wordsInDictionary = new Dictionary(dict);
        assertNull(wordsInDictionary.split(text));
    }
    @Test
    public void testIsWordsInDictionary_lastTwoWordsBothInDict_true() {
        String text = "mymym";
        List<String> dict = Arrays.asList("name", "is", "mym", "mymym", "my");
        Dictionary wordsInDictionary = new Dictionary(dict);
        assertNotNull(wordsInDictionary.split(text));
    }
    @Test
    public void testIsWordsInDictionary_severalConfusingWords_true() {
        String text = "correspondentingpostbot";
        String str = "correspondent correspondenting bot postbot";
        String[] strings = str.split(" ");
        List<String> dict = Arrays.asList(strings);
        Dictionary wordsInDictionary = new Dictionary(dict);
        assertNotNull(wordsInDictionary.split(text));
    }
    @Test
    public void testIsWordsInDictionary_severalConfusingWords2_true() {
        String text = "correspondentingpostbot";
        String str = "correspondent correspondenting bot postbot";
        String[] strings = str.split(" ");
        List<String> dict = Arrays.asList(strings);
        Dictionary wordsInDictionary = new Dictionary(dict);
        assertNotNull(wordsInDictionary.split(text));
    }
    @Test
    public void testIsWordsInDictionary_lastLetterWrong_false() {
        String text = "mymymm";
        List<String> dict = Arrays.asList("name", "is", "mym", "mymym");
        Dictionary wordsInDictionary = new Dictionary(dict);
        assertNull(wordsInDictionary.split(text));
    }
    @Test
    public void testIsWordsInDictionary_firstLetterWrong_false() {
        String text = "mmmymy";
        List<String> dict = Arrays.asList("name", "is", "my");
        Dictionary wordsInDictionary = new Dictionary(dict);
        assertNull(wordsInDictionary.split(text));
    }
    @Test
    public void testIsWordsInDictionary_oneLetter_false() {
        String text = "m";
        List<String> dict = Arrays.asList("name", "is", "my");
        Dictionary wordsInDictionary = new Dictionary(dict);
        assertNull(wordsInDictionary.split(text));
    }
    @Test
    public void testIsWordsInDictionary_severalRepeatedWords_true() {
        String text = "mymymisis";
        List<String> dict = Arrays.asList("name", "is", "my", "mym", "is", "isis", "misi");
        Dictionary wordsInDictionary = new Dictionary(dict);
        assertNotNull(wordsInDictionary.split(text));
    }
    @Test
    public void testIsWordsInDictionary_severalWords2_false() {
        String text = "correspondentingpostbot";
        List<String> dict = Arrays.asList("correspondent", "correspondenting", "bot");
        Dictionary wordsInDictionary = new Dictionary(dict);
        assertNull(wordsInDictionary.split(text));
    }
    @Test
    public void testIsWordsInDictionary_noLetters_true() {
        String text = "";
        List<String> dict = Arrays.asList("name", "is", "my");
        Dictionary wordsInDictionary = new Dictionary(dict);
        assertNotNull(wordsInDictionary.split(text));
    }
    @Test
    public void testIsWordsInDictionary_manyWords2_true() {
        String str = "Was kaum jemand außerhalb einschlägiger Literaturzirkel weiß: Neben seinem großen um";
        String[] temp = str.split(" ");
        List<String> list = Arrays.asList(temp);
        String text = "kaum";
        Dictionary wd = new Dictionary(list);
        assertNotNull(wd.split(text));
    }
}