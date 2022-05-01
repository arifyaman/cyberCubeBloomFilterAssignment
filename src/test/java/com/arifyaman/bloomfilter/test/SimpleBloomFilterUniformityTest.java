package com.arifyaman.bloomfilter.test;

import com.arifyaman.bloomfilter.SimpleBloomFilter;
import com.arifyaman.bloomfilter.hashing.*;
import com.arifyaman.bloomfilter.test.hashing.Murmur3HashFunction;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SimpleBloomFilterUniformityTest extends AbsWordListTest {

    /**
     *
     * @param words words to be tested with
     * @param h1 1st hash function
     * @param h2 2nd hash function
     * @param expectedDuplications we expect every word sets different 2 bit pair on filter. But we might have already 2 bit pair which is set for a new word. We try to see which hash functions give the best results.
     * @return Roughly probability of giving true when the word is not in the list (false positive probability)
     */
    public float testWithCustomTwoHashFunctions(List<String> words, HashFunction h1, HashFunction h2, int expectedDuplications) {
        SimpleBloomFilter simpleBloomFilter = new SimpleBloomFilter();
        simpleBloomFilter.setHashFunctions(Arrays.asList(h1, h2));
        int duplications = 0;
        for (String word : words) {
            if (simpleBloomFilter.mayContain(word)) {
                duplications++;
            }
            simpleBloomFilter.add(word);
        }
        Assert.assertEquals("Duplications are expected!", expectedDuplications, duplications);
        return (float) (((words.size() * 2) - simpleBloomFilter.cardinality())*100)/words.size();
    }


    @Test
    public void simpleBloomFilterWordUniformityTestWithCRCHashes() {
        Assert.assertTrue("False positive probability is less then 0.1%", testWithCustomTwoHashFunctions(getWords("wordlist.txt"), new CRC32HashFunction(), new CRC32CHashFunction(),0) < 0.1f);
    }


    @Test
    public void simpleBloomFilterWordUniformityTestWithFNVHashesOver1MInput() {
        Assert.assertTrue("False positive probability is less then 0.1%", testWithCustomTwoHashFunctions(getWords("wordlist.txt"), new FNVHashFunction(), new FNV64HashFunction(),0) < 0.1f);
    }


    /**
     * We have 1 duplication with FNV64 and CRC32 hashes over 1M words. So using these two hash functions together may not be a good choice
     */
    @Test
    public void simpleBloomFilterWordUniformityTestWithFNV64AndCRC32Over1MInput() {
        Assert.assertTrue("Using these two hash function pair is not the best idea.", testWithCustomTwoHashFunctions(getWords("wordlist2.txt"), new CRC32HashFunction(), new FNV64HashFunction(),1) < 0.1f);
    }

    /**
     * These two hash function pair gives the best time - uniformity result.
     */
    @Test
    public void simpleBloomFilterWordUniformityTestWithFNVAndCRC32Over1MInput() {
        Assert.assertTrue("False positive probability is less then 0.1%", testWithCustomTwoHashFunctions(getWords("wordlist2.txt"), new FNVHashFunction(), new CRC32HashFunction(),0) < 0.1f);
    }

    @Test
    public void simpleBloomFilterWordUniformityTestWithFNVAndCRC32() {
        Assert.assertTrue("False positive probability is less then 0.1%", testWithCustomTwoHashFunctions(getWords("wordlist.txt"), new FNVHashFunction(), new CRC32HashFunction(),0) < 0.1f);

    }

    @Test
    public void simpleBloomFilterWordUniformityTestWithFNV64AndCRC32COver1MInput() {
        Assert.assertTrue("Flse positive probability is less then 0.1%", testWithCustomTwoHashFunctions(getWords("wordlist2.txt"), new FNV64HashFunction(), new CRC32CHashFunction(),0) < 0.1f);
    }

    @Test
    public void simpleBloomFilterWordUniformityTestWithMurmur3AndCRC32Over1MInput() {
        Assert.assertTrue("False positive probability is less then 0.1%", testWithCustomTwoHashFunctions(getWords("wordlist2.txt"), new Murmur3HashFunction(), new CRC32HashFunction(),0) < 0.1f);
    }

    @Test
    public void simpleBloomFilterWordUniformityTestWithMurmur3AndFNVOver1MInput() {
        Assert.assertTrue("False positive probability is less then 0.1%", testWithCustomTwoHashFunctions(getWords("wordlist2.txt"), new Murmur3HashFunction(), new FNVHashFunction(),0) < 0.1f);
    }

    /**
     * Best uniformity result 0.091
     */
    @Test
    public void simpleBloomFilterWordUniformityTestWithMurmur3AndFNV64Over1MInput() {
        Assert.assertTrue("False positive probability is less then 0.1%", testWithCustomTwoHashFunctions(getWords("wordlist2.txt"), new Murmur3HashFunction(), new FNV64HashFunction(),0) < 0.1f);
    }


}
