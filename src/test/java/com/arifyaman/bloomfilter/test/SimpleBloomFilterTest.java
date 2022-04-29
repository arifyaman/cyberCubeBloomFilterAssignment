package com.arifyaman.bloomfilter.test;

import com.arifyaman.bloomfilter.SimpleBloomFilter;
import org.junit.After;
import org.junit.Before;
import static org.junit.Assert.*;
import org.junit.Test;

import java.util.List;

public class SimpleBloomFilterTest extends AbsWordListTest {
    SimpleBloomFilter simpleBloomFilter;

    @Before
    public void constructFilter() {
        List<String> words = getWords();
        long start = System.currentTimeMillis();
        simpleBloomFilter = new SimpleBloomFilter();
        for (String word : words) {
            simpleBloomFilter.add(word);
        }
        long end = System.currentTimeMillis();
        System.out.println("Constructed in " + (end-start) + " ms!");
    }

    @Test
    public void SimpleBloomFilterTest1() {
        long start = System.currentTimeMillis();
        boolean result = simpleBloomFilter.mayContain("Abbotsford's");
        long end = System.currentTimeMillis();
        System.out.println("Finished in " + (end-start) + " ms!");
        assertTrue(result);
    }

    @Test
    public void SimpleBloomFilterTest2() {
        long start = System.currentTimeMillis();
        boolean result = simpleBloomFilter.mayContain("zz456123");
        long end = System.currentTimeMillis();
        System.out.println("Finished in " + (end-start) + " ms!");
        assertFalse(result);
    }

    @Test
    public void SimpleBloomFilterTest3() {
        long start = System.currentTimeMillis();
        boolean result = simpleBloomFilter.mayContain("testing");
        long end = System.currentTimeMillis();
        System.out.println("Finished in " + (end-start) + " ms!");
        assertTrue(result);
    }

    @Test
    public void SimpleBloomFilterTest4() {
        long start = System.currentTimeMillis();
        boolean result = simpleBloomFilter.mayContain("satisfactorinesses");
        long end = System.currentTimeMillis();
        System.out.println("Finished in " + (end-start) + " ms!");
        assertTrue(result);
    }

    @After
    public void clearTheFilter(){
        simpleBloomFilter.clear();
    }


}
