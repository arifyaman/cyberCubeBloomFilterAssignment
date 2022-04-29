package com.arifyaman.bloomfilter.test;

import com.arifyaman.bloomfilter.hashing.*;
import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

public class WordUniformityTest extends AbsWordListTest {

    @Test
    public void fNVHashFunctionUniformityTest() throws IOException {
        FNVHashFunction FNVHashFunction = new FNVHashFunction();

        HashMap<Integer,Boolean> map = new HashMap<>();
        int wordCount = 0;
        int duplications = 0;
        List<String> words = getWords();

        long start = System.currentTimeMillis();

        for(String word : words) {
            int index = FNVHashFunction.hash(word.getBytes(StandardCharsets.UTF_8));
            if(map.get(index) != null && map.get(index)) duplications++;
            map.put(index, true);
            wordCount++;
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start + " ms!");
        System.out.println(words + " words!");
        System.out.println(duplications + " duplications!");
        System.out.println(map.values().size());

    }

    @Test
    public void myTestFunctionUniformityTest() throws IOException {
        MyTestHashFunction myTestHashFunction = new MyTestHashFunction();
        HashMap<Integer,Boolean> map = new HashMap<>();

        int words = 0;
        int duplications = 0;
        File file = new File("wordlist.txt");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        long start = System.currentTimeMillis();
        while ((line = br.readLine()) != null) {
            int index = myTestHashFunction.hash(line.getBytes(StandardCharsets.UTF_8));
            if(map.get(index) != null && map.get(index)) duplications++;
            map.put(index, true);
            words++;
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start + " ms!");
        System.out.println(words + " words!");
        System.out.println(duplications + " duplications!");
        System.out.println(map.values().size());
        fr.close();

    }

    @Test
    public void defaultHashFunctionUniformityTest() throws IOException {
        DefaultHashFunction defaultHashFunction = new DefaultHashFunction();
        HashMap<Integer,Boolean> map = new HashMap<>();
        int words = 0;
        int duplications = 0;
        File file = new File("wordlist.txt");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        long start = System.currentTimeMillis();
        while ((line = br.readLine()) != null) {
            int index = defaultHashFunction.hash(line.getBytes(StandardCharsets.UTF_8));
            if(map.get(index) != null && map.get(index)) duplications++;
            map.put(index, true);
            words++;
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start + " ms!");
        System.out.println(words + " words!");
        System.out.println(duplications + " duplications!");
        System.out.println(map.values().size());
        fr.close();

    }

    @Test
    public void cRC32hashFunctionUniformityTest() throws IOException {
        CRC32HashFunction crc32HashFunction = new CRC32HashFunction();
        HashMap<Integer,Boolean> map = new HashMap<>();
        int words = 0;
        int duplications = 0;
        File file = new File("wordlist.txt");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        long start = System.currentTimeMillis();
        while ((line = br.readLine()) != null) {
            int index = crc32HashFunction.hash(line.getBytes(StandardCharsets.UTF_8));
            if(map.get(index) != null && map.get(index)) duplications++;
            map.put(index, true);
            words++;
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start + " ms!");
        System.out.println(words + " words!");
        System.out.println(duplications + " duplications!");
        System.out.println(map.values().size());
        fr.close();

    }
    @Test
    public void cRC32CHashFunctionUniformityTest() throws IOException {
        CRC32CHashFunction crc32CHashFunction = new CRC32CHashFunction();
        HashMap<Integer,Boolean> map = new HashMap<>();
        int words = 0;
        int duplications = 0;
        File file = new File("wordlist.txt");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        long start = System.currentTimeMillis();
        while ((line = br.readLine()) != null) {
            int index = crc32CHashFunction.hash(line.getBytes(StandardCharsets.UTF_8));
            if(map.get(index) != null && map.get(index)) duplications++;
            map.put(index, true);
            words++;
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start + " ms!");
        System.out.println(words + " words!");
        System.out.println(duplications + " duplications!");
        System.out.println(map.values().size());
        fr.close();

    }

    @Test
    public void murmur3HashFunctionUniformityTest() throws IOException {
        Murmur3HashFunction murmur3HashFunction = new Murmur3HashFunction();
        HashMap<Integer,Boolean> map = new HashMap<>();
        int words = 0;
        int duplications = 0;
        File file = new File("wordlist.txt");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        long start = System.currentTimeMillis();
        while ((line = br.readLine()) != null) {
            int index = murmur3HashFunction.hash(line.getBytes(StandardCharsets.UTF_8));
            if(map.get(index) != null && map.get(index)) duplications++;
            map.put(index, true);
            words++;
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start + " ms!");
        System.out.println(words + " words!");
        System.out.println(duplications + " duplications!");
        System.out.println(map.values().size());
        fr.close();

    }

}
