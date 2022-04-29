package com.arifyaman.bloomfilter.test;

import com.arifyaman.bloomfilter.SimpleBloomFilter;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class SimpleBloomFilterUniformityTest extends AbsWordListTest {

    @Test
    public void simpleBloomFilterWordUniformityTest() {
        List<String> words = getWords("wordlist.txt");

        SimpleBloomFilter simpleBloomFilter = new SimpleBloomFilter();
        int duplications = 0;
        long start = System.currentTimeMillis();
        for (String word : words) {
            if(simpleBloomFilter.mayContain(word)){
                System.out.println(word+ "   duplicated");
                duplications++;
            }
            simpleBloomFilter.add(word);
        }
        long end = System.currentTimeMillis();

        System.out.println(end-start+ " ms!");
        System.out.println(duplications+ " duplications !");
        Assert.assertEquals("There should be no dublications", 0, duplications);


    }


}
