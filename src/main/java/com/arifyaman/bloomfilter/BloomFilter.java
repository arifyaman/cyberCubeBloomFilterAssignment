package com.arifyaman.bloomfilter;

import com.arifyaman.bloomfilter.hashing.HashFunction;

import java.util.List;

public interface BloomFilter<T> {
    /**
     * Does not trigger false positive even if the value is there the corresponding bits will be set.
     *
     * @param value the value will be added to list
     */
    void add(T value);

    void addList(List<T> values);

    /**
     * Clears the memory of the filter.
     */
    void clear();

    /**
     * @param hashFunctions the hash functions to be used.
     */
    void setHashFunctions(List<HashFunction> hashFunctions);

    /**
     * @param value the value will be checked if it might exist in the list.
     * @return true means it might exist in the list. false means the value 100% is not in the list.
     */
    boolean mayContain(T value);
}
