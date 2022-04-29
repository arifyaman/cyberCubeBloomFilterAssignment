package com.arifyaman.bloomfilter.test;

import com.github.eprst.murmur3.MurmurHash3;
import com.sangupta.murmur.Murmur2;
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

            File file = new File("wordlist.txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            long start = System.currentTimeMillis();
            while ((line = br.readLine()) != null) {
                MurmurHash3.HashCode128 out = new MurmurHash3.HashCode128();
                MurmurHash3.murmurhash3_x64_128_ascii(line, 0, line.length(), 0, out);
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
    public void murmur2HashSpeedTest() {

        try {
            int lines = 0;

            File file = new File("wordlist.txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            long start = System.currentTimeMillis();
            while ((line = br.readLine()) != null) {
                Murmur2.hash(line.getBytes(StandardCharsets.UTF_8), line.length(), 0);
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
