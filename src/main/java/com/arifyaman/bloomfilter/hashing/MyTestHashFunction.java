package com.arifyaman.bloomfilter.hashing;

public class MyTestHashFunction implements HashFunction{

    @Override
    public int hash(byte[] value) {
        int result = 0;
        for(byte b : value){
            result += (Byte.toUnsignedInt(b) + 2) ;
        }
        return result;
    }
}
