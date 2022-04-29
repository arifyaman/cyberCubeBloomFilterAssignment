package com.arifyaman.bloomfilter.test;

import com.arifyaman.bloomfilter.SimpleBlurFilter;
import org.junit.Before;
import static org.junit.Assert.*;
import org.junit.Test;

import java.util.List;

public class SimpleBloomFilterTest extends WordListTest {
    SimpleBlurFilter simpleBlurFilter;

    @Before
    public void constructFilter(){
        List<String> words = getWords();
        simpleBlurFilter = new SimpleBlurFilter();
        for (String word : words) {
            simpleBlurFilter.add(word);
        }
    }

    @Test
    public void SimpleBloomFilterTest1() {
        boolean result = simpleBlurFilter.mayContain("Abbotsford's");
        assertTrue(result);
    }

    @Test
    public void SimpleBloomFilterTest2() {
        boolean result = simpleBlurFilter.mayContain("zz456123");
        assertFalse(result);
    }

    @Test
    public void SimpleBloomFilterTest3() {
        boolean result = simpleBlurFilter.mayContain("testing");
        assertTrue(result);
    }
    @Test
    public void SimpleBloomFilterTest4() {
        boolean result = simpleBlurFilter.mayContain("satisfactorinesses");
        assertTrue(result);
    }


}
