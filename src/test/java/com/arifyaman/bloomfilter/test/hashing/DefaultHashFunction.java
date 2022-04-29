package com.arifyaman.bloomfilter.test.hashing;

import com.arifyaman.bloomfilter.hashing.HashFunction;

import java.util.Arrays;

public class DefaultHashFunction implements HashFunction {
    @Override
    public int hash(byte[] value) {
        return Arrays.hashCode(value);

    }
}
