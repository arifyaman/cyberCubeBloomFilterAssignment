package com.arifyaman.bloomfilter.test;

import com.arifyaman.bloomfilter.SimpleBloomFilter;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SimpleBloomFilterTest extends AbsWordListTest {
    static SimpleBloomFilter simpleBloomFilter;

    /**
     * We construct the filter one time, we are testing with the same input through the tests.
     */
    @Before
    public void constructFilter() {
        if(simpleBloomFilter != null) return;

        simpleBloomFilter = new SimpleBloomFilter();
        simpleBloomFilter.addList(getWords("wordlist.txt"));
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

    @AfterClass
    public static void clearTheFilter() {
        simpleBloomFilter.clear();
    }


}
