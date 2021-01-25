package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnagramTest {

    @Test
    public void whenAnagram_ReturnTrue(){
        assertTrue(Anagram.isAnagram("keep","peek"));
    }

    @Test
    public void whenNotAnagram_ReturnFalse(){
        assertFalse(Anagram.isAnagram("keep","peak"));

    }

    @Test
    public void whenDifferentSize_ReturnFalse(){
        assertFalse(Anagram.isAnagram("keep cool","keep"));
    }

    @Test
    public void whenAnagramWithSpaces_ReturnTrue(){
        assertTrue(Anagram.isAnagram("keep cool","keep loco"));
    }

}