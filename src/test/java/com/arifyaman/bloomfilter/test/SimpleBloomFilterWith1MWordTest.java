package com.arifyaman.bloomfilter.test;

import com.arifyaman.bloomfilter.SimpleBloomFilter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SimpleBloomFilterWith1MWordTest extends AbsWordListTest {
    SimpleBloomFilter simpleBloomFilter;

    @Before
    public void constructFilter() {
        simpleBloomFilter = new SimpleBloomFilter();
        simpleBloomFilter.addList(getWords("wordlist2.txt"));
    }

    boolean tryToTestWithWord(String word) {
        return simpleBloomFilter.mayContain(word);
    }

    @Test
    public void simpleBloomFilterTest1() {
        assertTrue(tryToTestWithWord("sb5101e"));
    }

    @Test
    public void simpleBloomFilterTest2() {
        assertFalse(tryToTestWithWord("xxlqwkukxxczc22323"));
    }


    @Test
    public void simpleBloomFilterTest3() {
        assertTrue(tryToTestWithWord("8218yxfy"));
    }

    @Test
    public void simpleBloomFilterTest4() {
        assertTrue(tryToTestWithWord("X3Yer7p9"));
    }

    @Test
    public void simpleBloomFilterTest5() {
        assertTrue(tryToTestWithWord("xxlOtUoHGA51."));
    }

    @Test
    public void simpleBloomFilterTest6() {
        assertFalse(tryToTestWithWord("vu4ii."));
    }

    @After
    public void clearTheFilter() {
        simpleBloomFilter.clear();
    }


}
