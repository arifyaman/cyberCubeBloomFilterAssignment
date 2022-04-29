package com.arifyaman.bloomfilter.test;

import com.arifyaman.bloomfilter.SimpleBloomFilter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SimpleBloomFilterTest extends AbsWordListTest {
    SimpleBloomFilter simpleBloomFilter;

    @Before
    public void constructFilter() {
        List<String> words = getWords("wordlist.txt");
        simpleBloomFilter = new SimpleBloomFilter();
        for (String word : words) {
            simpleBloomFilter.add(word);
        }
    }

    boolean tryToTestWithWord(String word) {
        return simpleBloomFilter.mayContain(word);
    }

    @Test
    public void simpleBloomFilterTest1() {
        assertTrue(tryToTestWithWord("Abbotsford's"));
    }

    @Test
    public void simpleBloomFilterTest2() {
        assertFalse(tryToTestWithWord("zz456123"));
    }

    @Test
    public void simpleBloomFilterTest3() {
        assertTrue(tryToTestWithWord("testing"));
    }

    @Test
    public void simpleBloomFilterTest4() {
        assertTrue(tryToTestWithWord("satisfactorinesses"));
    }

    @After
    public void clearTheFilter(){
        simpleBloomFilter.clear();
    }


}
