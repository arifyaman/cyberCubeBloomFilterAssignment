package com.arifyaman.bloomfilter.hashing;

public interface HashFunction {
    /**
     *
     * @param value bytes to be hashed
     * @return range starts from 0 it should return a position.
     */
    int hash(byte[] value);
}
