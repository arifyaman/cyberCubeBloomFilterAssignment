package com.arifyaman.bloomfilter.hashing;


public class FNV64HashFunction implements HashFunction {

    @Override
    public int hash(byte[] value) {
        long FNV_OFFSET_BASIS = 0xcbf29ce484222325L;
        long FNV_PRIME = 0x100000001b3L;

        if (value == null)
            return 0;

        long result = FNV_OFFSET_BASIS;

        for (byte element : value) {
            result = result * FNV_PRIME;
            result ^= element;
        }

        return Math.abs((int) result);
    }
}
