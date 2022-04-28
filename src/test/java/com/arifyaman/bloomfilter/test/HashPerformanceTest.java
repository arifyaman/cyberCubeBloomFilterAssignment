package com.arifyaman.bloomfilter.test;

import com.github.eprst.murmur3.MurmurHash3;
import com.sangupta.murmur.Murmur2;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class HashPerformanceTest {

    @Test
    void Murmurhash3_x64_128_asciiSpeedTest() {
        try {
            int lines = 0;

            File file = new File("wordlist.txt");    //creates a new file instance
            FileReader fr = new FileReader(file);   //reads the file
            BufferedReader br = new BufferedReader(fr);  //creates a buffering character input stream
            StringBuffer sb = new StringBuffer();    //constructs a string buffer with no characters
            String line;
            long start = System.currentTimeMillis();
            while ((line = br.readLine()) != null) {
                MurmurHash3.HashCode128 out = new MurmurHash3.HashCode128();

                sb.append(line);      //appends line to string buffer
                sb.append("\n");     //line feed
                MurmurHash3.murmurhash3_x64_128_ascii(line, 0, line.length(), 0, out);

                lines++;
            }
            fr.close();    //closes the stream and release the resources
            long end = System.currentTimeMillis();

            System.out.println(end - start + " ms!");
            System.out.println(lines + " lines are hashed!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    void AnotherTest() {
        try {
            int lines = 0;

            File file = new File("wordlist.txt");    //creates a new file instance
            FileReader fr = new FileReader(file);   //reads the file
            BufferedReader br = new BufferedReader(fr);  //creates a buffering character input stream
            StringBuffer sb = new StringBuffer();    //constructs a string buffer with no characters
            String line;
            long start = System.currentTimeMillis();
            while ((line = br.readLine()) != null) {

                sb.append(line);      //appends line to string buffer
                sb.append("\n");     //line feed
                System.out.println(Murmur2.hash(line.getBytes(StandardCharsets.UTF_8), line.length(), 0));
                lines++;
            }
            fr.close();    //closes the stream and release the resources
            long end = System.currentTimeMillis();

            System.out.println(end - start + " ms!");
            System.out.println(lines + " lines are hashed!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
