package com.arifyaman.bloomfilter.test;

import com.arifyaman.bloomfilter.test.hashing.Murmur3HashFunction;
import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashPerformanceTest extends AbsWordListTest {

    @Test
    public void murmurhash3_x64_128_asciiSpeedTest() {

        int lines = 0;
        Murmur3HashFunction murmur3HashFunction = new Murmur3HashFunction();
        long start = System.currentTimeMillis();
        for (String word : getWords("wordlist.txt")) {
            murmur3HashFunction.hash(word.getBytes(StandardCharsets.UTF_8));
            lines++;
        }

        long end = System.currentTimeMillis();
        System.out.println(end - start + " ms!");
        System.out.println(lines + " lines are hashed!");

    }


    @Test
    public void sHA256SpeedTest() {
        try {
            int lines = 0;
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            long start = System.currentTimeMillis();
            for (String word : getWords("wordlist.txt")) {
                byte[] encodedhash = digest.digest(
                        word.getBytes(StandardCharsets.US_ASCII));
                lines++;
            }
            long end = System.currentTimeMillis();


            System.out.println(end - start + " ms!");
            System.out.println(lines + " lines are hashed!");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

    }


}
