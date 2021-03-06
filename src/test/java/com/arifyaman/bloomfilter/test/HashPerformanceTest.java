package com.arifyaman.bloomfilter.test;

import com.arifyaman.bloomfilter.test.hashing.Murmur3HashFunction;
import org.junit.Assert;
import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashPerformanceTest extends AbsWordListTest {

    @Test
    public void murmurhash3_x64_128_asciiSpeedTest() {
        Murmur3HashFunction murmur3HashFunction = new Murmur3HashFunction();
        long start = System.currentTimeMillis();
        for (String word : getWords("wordlist.txt")) {
            murmur3HashFunction.hash(word.getBytes(StandardCharsets.UTF_8));
        }

        long end = System.currentTimeMillis();
        Assert.assertTrue("Time is acceptable", end-start<700);
    }


    @Test
    public void sHA256SpeedTest() {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            long start = System.currentTimeMillis();
            for (String word : getWords("wordlist.txt")) {
                byte[] encodedhash = digest.digest(
                        word.getBytes(StandardCharsets.US_ASCII));
            }
            long end = System.currentTimeMillis();
            Assert.assertTrue("Time is acceptable", end-start<700);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }


}
