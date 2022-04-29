package com.arifyaman.bloomfilter.test;

import com.arifyaman.bloomfilter.SimpleBloomFilter;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BasicBloomFilterTest {
    SimpleBloomFilter simpleBloomFilter;

    @Before
    public void construct() {
        simpleBloomFilter = new SimpleBloomFilter();
    }

    @Test
    public void basicAddAndCheck() {
        simpleBloomFilter.add("bloomFilterTest");
        boolean result = simpleBloomFilter.mayContain("bloomFilterTest");
        assertTrue(result);
    }

    @Test
    public void basicAddAndCheck2() {
        simpleBloomFilter.add("bloomFilterTest");
        boolean result = simpleBloomFilter.mayContain("testFilterBloom");
        assertFalse(result);
    }




}
