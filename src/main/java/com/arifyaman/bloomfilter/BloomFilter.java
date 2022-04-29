package com.arifyaman.bloomfilter;

import com.arifyaman.bloomfilter.hashing.HashFunction;

import java.util.List;

public interface BloomFilter<T> {
    /**
     *  Does not trigger false positive even if the value is there it will be set.
     * @param value the value will be added to list
     */
    void add(T value);

    /**
     * Clears the memory of the filter.
     */
    void clear();

    /**
     *
     * @param hashFunctions the hash functions to be used.
     */
    void setHashFunctions(List<HashFunction> hashFunctions);

    /**
     *
     * @param value the value will be checked if it might exist in the list. true means it might exist in the list. No means 100% is not in the list.
     * @return
     */
    boolean mayContain(T value);
}
