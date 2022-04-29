package com.arifyaman.bloomfilter.hashing;

public interface HashFunction {
    int hash(byte[] value);
}
