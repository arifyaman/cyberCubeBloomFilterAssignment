package com.arifyaman.bloomfilter.test;

import com.arifyaman.bloomfilter.test.hashing.Murmur3HashFunction;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashPerformanceTest {

    @Test
    public void murmurhash3_x64_128_asciiSpeedTest() {
        try {
            int lines = 0;
            Murmur3HashFunction murmur3HashFunction = new Murmur3HashFunction();
            File file = new File("wordlist.txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            long start = System.currentTimeMillis();
            while ((line = br.readLine()) != null) {
                murmur3HashFunction.hash(line.getBytes(StandardCharsets.UTF_8));
                lines++;
            }
            long end = System.currentTimeMillis();
            fr.close();


            System.out.println(end - start + " ms!");
            System.out.println(lines + " lines are hashed!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void sHA256SpeedTest() {
        try {
            int lines = 0;
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            File file = new File("wordlist.txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            long start = System.currentTimeMillis();
            while ((line = br.readLine()) != null) {
                byte[] encodedhash = digest.digest(
                        line.getBytes(StandardCharsets.US_ASCII));
                lines++;
            }
            long end = System.currentTimeMillis();
            fr.close();


            System.out.println(end - start + " ms!");
            System.out.println(lines + " lines are hashed!");
        } catch (IOException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }


}
