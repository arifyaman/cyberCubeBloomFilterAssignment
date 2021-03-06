package com.arifyaman.bloomfilter.test;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class AbsWordListTest {

    protected List<String> getWords(String wordListTxt) {
        ArrayList<String> words = new ArrayList<>();
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            File file = new File(classLoader.getResource(wordListTxt).getFile());
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
