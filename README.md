# CyberCube Bloom Filter Assignment
An external jar library can be found in /dist folder.

Currently, SimpleBloomFilter supports String objects.

By default, uses 2 hash functions (Fowler–Noll–Vo and CRC32) together. But an external hash functions (Which extends from HashFunction interface) can be written and delivered to SimpleBloomFilter. Different hash function tests can be found in test package.
