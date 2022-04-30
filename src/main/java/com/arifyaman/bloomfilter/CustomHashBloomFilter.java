package com.arifyaman.bloomfilter;

import com.arifyaman.bloomfilter.hashing.HashFunction;

import java.util.List;

public class CustomHashBloomFilter implements BloomFilter<String>{

    @Override
    public void add(String value) {

    }

    @Override
    public void addList(List<String> values) {

    }

    @Override
    public void clear() {

    }

    @Override
    public void setHashFunctions(List<HashFunction> hashFunctions) {

    }

    @Override
    public boolean mayContain(String value) {
        return false;
    }
}
