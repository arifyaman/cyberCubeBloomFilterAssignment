package com.arifyaman.bloomfilter.test;

import com.arifyaman.bloomfilter.SimpleBlurFilter;
import org.junit.Test;

import java.util.List;

public class SimpleBloomFilterUniformityTest extends WordListTest {

    @Test
    public void SimpleBloomFilterWordUniformityTest() {
        List<String> words = getWords();
        SimpleBlurFilter simpleBlurFilter = new SimpleBlurFilter();
        int duplications = 0;
        long start = System.currentTimeMillis();
        for (String word : words) {
            if(simpleBlurFilter.mayContain(word)) duplications++;
            simpleBlurFilter.add(word);
        }
        long end = System.currentTimeMillis();

        System.out.println(end-start+ " ms!");
        System.out.println(duplications+ " duplications !");

    }


}
