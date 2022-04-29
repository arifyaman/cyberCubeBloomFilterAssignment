package com.arifyaman.bloomfilter;

import com.arifyaman.bloomfilter.hashing.CRC32CHashFunction;
import com.arifyaman.bloomfilter.hashing.CRC32HashFunction;
import com.arifyaman.bloomfilter.hashing.HashFunction;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

public class SimpleBlurFilter implements BloomFilter<String> {
    HashFunction h1;
    HashFunction h2;

    BitSet bitSet;

    public SimpleBlurFilter() throws IllegalAccessException {
        bitSet = new BitSet();
        setHashFunctions(Arrays.asList(new CRC32CHashFunction(), new CRC32HashFunction()));
    }

    @Override
    public void add(String value) {
        bitSet.set(h1.hash(value.getBytes(StandardCharsets.UTF_8)));
        bitSet.set(h2.hash(value.getBytes(StandardCharsets.UTF_8)));
    }

    @Override
    public void setHashFunctions(List<HashFunction> hashFunctions) throws IllegalAccessException {
        if (hashFunctions.size() != 2) throw new IllegalAccessException("2 Hash functions are expected!");
        h1 = hashFunctions.get(0);
        h2 = hashFunctions.get(1);
    }

    @Override
    public boolean mayContain(String value) {
        if(!bitSet.get(h1.hash(value.getBytes(StandardCharsets.UTF_8)))) return false;
        return bitSet.get(h2.hash(value.getBytes(StandardCharsets.UTF_8)));
    }
}
