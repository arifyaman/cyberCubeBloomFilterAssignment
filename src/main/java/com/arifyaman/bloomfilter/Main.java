package com.arifyaman.bloomfilter;

import com.arifyaman.bloomfilter.hashing.CRC32CHashFunction;
import com.arifyaman.bloomfilter.hashing.CRC32HashFunction;
import com.arifyaman.bloomfilter.hashing.FNVHashFunction;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.nio.charset.StandardCharsets;
import java.util.BitSet;

public class Main {
    public static void main(String[] args) {
        FNVHashFunction hashFunction = new FNVHashFunction();
        BitSet set = new BitSet();

        CRC32HashFunction function1 = new CRC32HashFunction();
        CRC32CHashFunction function2 = new CRC32CHashFunction();

        System.out.println(function1.hash("asd".getBytes(StandardCharsets.UTF_8)));
        System.out.println(function2.hash("asd".getBytes(StandardCharsets.UTF_8)));
    }

}

