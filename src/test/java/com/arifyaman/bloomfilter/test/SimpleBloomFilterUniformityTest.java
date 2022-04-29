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
        for (String word : words) {
            if(simpleBloomFilter.mayContain(word)){
                duplications++;
            }
            simpleBloomFilter.add(word);
        }

        Assert.assertEquals("There should be no duplications", 0, duplications);


    }


}
