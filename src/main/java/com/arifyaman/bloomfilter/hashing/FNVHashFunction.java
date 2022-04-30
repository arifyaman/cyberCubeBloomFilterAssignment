package com.arifyaman.bloomfilter.hashing;

public class FNVHashFunction implements HashFunction {

    @Override
    public int hash(byte[] value) {

        long FNV_PRIME = 16777619;
        long FNV_OFFSET_BASIS = 2166136261L;

        if (value == null)
            return 0;

        long result = FNV_OFFSET_BASIS;
        for (byte element : value) {
            result = (result * FNV_PRIME);
            result ^= element;
        }

        return Math.abs((int) result);
    }
}
