package com.arifyaman.bloomfilter.hashing;

public class Murmur3HashFunction implements HashFunction{

    @Override
    public int hash(byte[] value) {
        int h1 = 2;
        int c1 = 0xcc9e2d51;
        int c2 = 0x1b873593;
        int len = value.length;
        int i = 0;

        while (len >= 4) {
            int k1  = (value[i++] & 0xFF);
            k1 |= (value[i++] & 0xFF) << 8;
            k1 |= (value[i++] & 0xFF) << 16;
            k1 |= (value[i++] & 0xFF) << 24;

            k1 *= c1;
            k1 = Integer.rotateLeft(k1, 15);
            k1 *= c2;

            h1 ^= k1;
            h1 = Integer.rotateLeft(h1, 13);
            h1 = h1 * 5 + 0xe6546b64;

            len -= 4;
        }

        //processingRemaining()
        int k1 = 0;
        switch (len) {
            case 3:
                k1 ^= (value[i + 2] & 0xFF) << 16;
                // fall through
            case 2:
                k1 ^= (value[i + 1] & 0xFF) << 8;
                // fall through
            case 1:
                k1 ^= (value[i] & 0xFF);

                k1 *= c1;
                k1 = Integer.rotateLeft(k1, 15);
                k1 *= c2;
                h1 ^= k1;
        }
        i += len;

        //makeHash()
        h1 ^= i;

        h1 ^= h1 >>> 16;
        h1 *= 0x85ebca6b;
        h1 ^= h1 >>> 13;
        h1 *= 0xc2b2ae35;
        h1 ^= h1 >>> 16;

        return h1;
    }
}
