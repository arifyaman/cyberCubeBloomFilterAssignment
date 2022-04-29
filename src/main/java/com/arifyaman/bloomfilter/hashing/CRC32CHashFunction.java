package com.arifyaman.bloomfilter.hashing;

import java.util.zip.CRC32C;

public class CRC32CHashFunction implements HashFunction{
    @Override
    public int hash(byte[] value) {
        CRC32C crc = new CRC32C();
        crc.update(value);


        return (int) crc.getValue();
    }
}
