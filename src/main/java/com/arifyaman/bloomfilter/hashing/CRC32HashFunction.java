package com.arifyaman.bloomfilter.hashing;

import java.util.zip.CRC32;

public class CRC32HashFunction implements HashFunction {
    @Override
    public int hash(byte[] value) {
        CRC32 crc = new CRC32();
        crc.update(value);


        return (int) crc.getValue();
    }
}
