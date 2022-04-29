package com.arifyaman.bloomfilter.hashing;

import java.util.Arrays;

public class DefaultHashFunction implements HashFunction{
    @Override
    public int hash(byte[] value) {
        return Arrays.hashCode(value);

    }
}
