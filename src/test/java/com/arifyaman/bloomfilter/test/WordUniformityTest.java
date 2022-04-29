package com.arifyaman.bloomfilter.test;

import com.arifyaman.bloomfilter.hashing.CRC32CHashFunction;
import com.arifyaman.bloomfilter.hashing.CRC32HashFunction;
import com.arifyaman.bloomfilter.test.hashing.DefaultHashFunction;
import com.arifyaman.bloomfilter.test.hashing.FNVHashFunction;
import com.arifyaman.bloomfilter.test.hashing.Murmur3HashFunction;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

public class WordUniformityTest extends AbsWordListTest {

    @Test
    public void fNVHashFunctionUniformityTest() throws IOException {
        FNVHashFunction fnvHashFunction = new FNVHashFunction();

        HashMap<Integer, Boolean> map = new HashMap<>();
        int duplications = 0;

        for (String word : getWords("wordlist.txt")) {
            int index = fnvHashFunction.hash(word.getBytes(StandardCharsets.UTF_8));
            if (map.get(index) != null && map.get(index)) duplications++;
            map.put(index, true);
        }

        Assert.assertTrue("Duplications are acceptable", duplications < 100);

    }

    /**
     * Default hash function is not practical for bloom filters !
     *
     * @throws IOException
     */
    @Test
    public void defaultHashFunctionUniformityTest() throws IOException {
        DefaultHashFunction defaultHashFunction = new DefaultHashFunction();
        HashMap<Integer, Boolean> map = new HashMap<>();
        int duplications = 0;

        for (String word : getWords("wordlist.txt")) {
            int index = defaultHashFunction.hash(word.getBytes(StandardCharsets.UTF_8));
            if (map.get(index) != null && map.get(index)) duplications++;
            map.put(index, true);
        }

        Assert.assertTrue("Too much duplications", duplications > 100);
    }

    @Test
    public void cRC32hashFunctionUniformityTest() throws IOException {
        CRC32HashFunction crc32HashFunction = new CRC32HashFunction();
        HashMap<Integer, Boolean> map = new HashMap<>();
        int duplications = 0;

        for (String word : getWords("wordlist.txt")) {
            int index = crc32HashFunction.hash(word.getBytes(StandardCharsets.UTF_8));
            if (map.get(index) != null && map.get(index)) duplications++;
            map.put(index, true);
        }

        Assert.assertTrue("Duplications are acceptable", duplications < 100);
    }

    @Test
    public void cRC32CHashFunctionUniformityTest() throws IOException {
        CRC32CHashFunction crc32CHashFunction = new CRC32CHashFunction();
        HashMap<Integer, Boolean> map = new HashMap<>();
        int duplications = 0;

        for (String word : getWords("wordlist.txt")) {
            int index = crc32CHashFunction.hash(word.getBytes(StandardCharsets.UTF_8));
            if (map.get(index) != null && map.get(index)) duplications++;
            map.put(index, true);
        }

        Assert.assertTrue("Duplications are acceptable", duplications < 100);
    }

    @Test
    public void murmur3HashFunctionUniformityTest() throws IOException {
        Murmur3HashFunction murmur3HashFunction = new Murmur3HashFunction();
        HashMap<Integer, Boolean> map = new HashMap<>();
        int duplications = 0;
        for (String word : getWords("wordlist.txt")) {
            int index = murmur3HashFunction.hash(word.getBytes(StandardCharsets.UTF_8));
            if (map.get(index) != null && map.get(index)) duplications++;
            map.put(index, true);
        }

        Assert.assertTrue("Duplications are acceptable", duplications < 100);
    }

}
