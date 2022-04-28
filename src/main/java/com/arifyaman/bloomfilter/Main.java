package com.arifyaman.bloomfilter;

import com.github.eprst.murmur3.MurmurHash3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        MurmurHash3.HashCode128 out = new MurmurHash3.HashCode128();

        MurmurHash3.murmurhash3_x64_128_ascii("anan",0,4,0,out);
        System.out.println(out.toLong());


    }

}

