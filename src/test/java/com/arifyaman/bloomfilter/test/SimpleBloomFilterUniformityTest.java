package com.arifyaman.bloomfilter.test;

import com.arifyaman.bloomfilter.SimpleBloomFilter;
import com.arifyaman.bloomfilter.hashing.CRC32CHashFunction;
import com.arifyaman.bloomfilter.hashing.CRC32HashFunction;
import com.arifyaman.bloomfilter.hashing.FNV64HashFunction;
import com.arifyaman.bloomfilter.hashing.FNVHashFunction;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class SimpleBloomFilterUniformityTest extends AbsWordListTest {

    @Test
    public void simpleBloomFilterWordUniformityTestWithCRCHashes() {
        SimpleBloomFilter simpleBloomFilter = new SimpleBloomFilter();
        simpleBloomFilter.setHashFunctions(Arrays.asList(new CRC32HashFunction(), new CRC32CHashFunction()));
        int duplications = 0;
        for (String word : getWords("wordlist.txt")) {
            if (simpleBloomFilter.mayContain(word)) {
                duplications++;
            }
            simpleBloomFilter.add(word);
        }

        Assert.assertEquals("There should be no duplications", 0, duplications);
    }


    @Test
    public void simpleBloomFilterWordUniformityTestWithFNVHashesOver1MInput() {
        SimpleBloomFilter simpleBloomFilter = new SimpleBloomFilter();
        simpleBloomFilter.setHashFunctions(Arrays.asList(new FNVHashFunction(), new FNV64HashFunction()));

        int duplications = 0;
        for (String word : getWords("wordlist2.txt")) {
            if (simpleBloomFilter.mayContain(word)) {
                duplications++;
            }
            simpleBloomFilter.add(word);
        }

        Assert.assertEquals("There should be no duplications", 0, duplications);
    }


    /**
     * We have 1 duplication with FNV64 and CRC32 hashes over 1M words. So using these two hash functions together may not a good choice
     */
    @Test
    public void simpleBloomFilterWordUniformityTestWithFNV64AndCRC32Over1MInput() {
        SimpleBloomFilter simpleBloomFilter = new SimpleBloomFilter();
        simpleBloomFilter.setHashFunctions(Arrays.asList(new CRC32HashFunction(), new FNV64HashFunction()));

        int duplications = 0;
        for (String word : getWords("wordlist2.txt")) {
            if (simpleBloomFilter.mayContain(word)) {
                duplications++;
            }
            simpleBloomFilter.add(word);
        }

        Assert.assertTrue("There are duplications not practical if we have better options.", duplications > 0);
    }

    /**
     * These two hash function pair gives the best time - uniformity result.
     */
    @Test
    public void simpleBloomFilterWordUniformityTestWithFNVAndCRC32Over1MInput() {
        SimpleBloomFilter simpleBloomFilter = new SimpleBloomFilter();
        simpleBloomFilter.setHashFunctions(Arrays.asList(new FNVHashFunction(), new CRC32HashFunction()));

        int duplications = 0;
        for (String word : getWords("wordlist2.txt")) {
            if (simpleBloomFilter.mayContain(word)) {
                duplications++;
            }
            simpleBloomFilter.add(word);
        }
        Assert.assertEquals("There should be no duplications", 0, duplications);
    }

    @Test
    public void simpleBloomFilterWordUniformityTestWithFNVAndCRC32() {
        SimpleBloomFilter simpleBloomFilter = new SimpleBloomFilter();
        simpleBloomFilter.setHashFunctions(Arrays.asList(new FNVHashFunction(), new CRC32HashFunction()));

        int duplications = 0;
        for (String word : getWords("wordlist.txt")) {
            if (simpleBloomFilter.mayContain(word)) {
                duplications++;
            }
            simpleBloomFilter.add(word);
        }

        Assert.assertEquals("There should be no duplications", 0, duplications);
    }

    @Test
    public void simpleBloomFilterWordUniformityTestWithFNV64AndCRC32COver1MInput() {
        SimpleBloomFilter simpleBloomFilter = new SimpleBloomFilter();
        simpleBloomFilter.setHashFunctions(Arrays.asList(new FNV64HashFunction(), new CRC32CHashFunction()));

        int duplications = 0;
        for (String word : getWords("wordlist2.txt")) {
            if (simpleBloomFilter.mayContain(word)) {
                duplications++;
            }
            simpleBloomFilter.add(word);
        }

        Assert.assertEquals("There should be no duplications", 0, duplications);
    }


}
