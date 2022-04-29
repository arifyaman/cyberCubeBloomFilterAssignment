package com.arifyaman.bloomfilter.test;

import com.github.eprst.murmur3.MurmurHash3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WordListTest {

    List<String> getWords(){
        ArrayList<String> words = new ArrayList<>();
        try {

            File file = new File("wordlist.txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                words.add(line);
            }
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return words;
    }

}
