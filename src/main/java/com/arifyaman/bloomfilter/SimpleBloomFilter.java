package com.arifyaman.bloomfilter;

import com.arifyaman.bloomfilter.hashing.CRC32CHashFunction;
import com.arifyaman.bloomfilter.hashing.CRC32HashFunction;
import com.arifyaman.bloomfilter.hashing.HashFunction;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/**
 * Uses 2 hash functions (CRC32 nd CRC32C) together.
 */
public class SimpleBloomFilter implements BloomFilter<String> {
    private HashFunction h1;
    private HashFunction h2;

    private BitSet bitSet;

    public SimpleBloomFilter() {
        bitSet = new BitSet();
        setHashFunctions(Arrays.asList(new CRC32CHashFunction(), new CRC32HashFunction()));
    }

    /*
      Bitset is thread safe for reading. Let's make sure adding into it is ok for multi threading as well.
     */
    @Override
    public synchronized void add(String value) {
        bitSet.set(h1.hash(value.getBytes(StandardCharsets.UTF_8)));
        bitSet.set(h2.hash(value.getBytes(StandardCharsets.UTF_8)));
    }

    @Override
    public synchronized void addList(List<String> values) {
        for(String value : values) {
            add(value);
        }
    }

    @Override
    public void setHashFunctions(List<HashFunction> hashFunctions) {
        if (hashFunctions.size() != 2) throw new IllegalArgumentException("2 Hash functions are expected!");
        h1 = hashFunctions.get(0);
        h2 = hashFunctions.get(1);
    }

    @Override
    public boolean mayContain(String value) {
        if (!bitSet.get(h1.hash(value.getBytes(StandardCharsets.UTF_8)))) return false;
        return bitSet.get(h2.hash(value.getBytes(StandardCharsets.UTF_8)));
    }

    public int length() {
        return bitSet.length();
    }

    public int size() {
        return bitSet.size();
    }

    public int cardinality() {
        return bitSet.cardinality();
    }

    @Override
    public void clear() {
        bitSet.clear();
    }
}
