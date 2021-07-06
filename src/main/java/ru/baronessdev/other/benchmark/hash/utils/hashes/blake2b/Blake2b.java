package ru.baronessdev.other.benchmark.hash.utils.hashes.blake2b;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Hex;

import java.security.Security;

public class Blake2b {

    // Provider
    static {
        Security.insertProviderAt(new BouncyCastleProvider(), 1);
    }

    /**
     * Source code:
     * https://github.com/rtyley/spongycastle/blob/spongy-master/core/src/main/java/org/spongycastle/crypto/digests/Blake2bDigest.java
     *
     * @param input string
     * @return Hash string
     */
    public static String blake2b160(final String input) {
        org.bouncycastle.jcajce.provider.digest.Blake2b.Blake2b160 blake2b160 = new org.bouncycastle.jcajce.provider.digest.Blake2b.Blake2b160();
        byte[] digest = blake2b160.digest(input.getBytes());
        return Hex.toHexString(digest);
    }

    /**
     * Source code:
     * https://github.com/rtyley/spongycastle/blob/spongy-master/core/src/main/java/org/spongycastle/crypto/digests/Blake2bDigest.java
     *
     * @param input string
     * @return Hash string
     */
    public static String blake2b256(final String input) {
        org.bouncycastle.jcajce.provider.digest.Blake2b.Blake2b256 blake2b256 = new org.bouncycastle.jcajce.provider.digest.Blake2b.Blake2b256();
        byte[] digest = blake2b256.digest(input.getBytes());
        return Hex.toHexString(digest);
    }

    /**
     * Source code:
     * https://github.com/rtyley/spongycastle/blob/spongy-master/core/src/main/java/org/spongycastle/crypto/digests/Blake2bDigest.java
     *
     * @param input string
     * @return Hash string
     */
    public static String blake2b384(final String input) {
        org.bouncycastle.jcajce.provider.digest.Blake2b.Blake2b384 blake2b384 = new org.bouncycastle.jcajce.provider.digest.Blake2b.Blake2b384();
        byte[] digest = blake2b384.digest(input.getBytes());
        return Hex.toHexString(digest);
    }

    /**
     * Source code:
     * https://github.com/rtyley/spongycastle/blob/spongy-master/core/src/main/java/org/spongycastle/crypto/digests/Blake2bDigest.java
     *
     * @param input string
     * @return Hash string
     */
    public static String blake2b512(final String input) {
        org.bouncycastle.jcajce.provider.digest.Blake2b.Blake2b512 blake2b512 = new org.bouncycastle.jcajce.provider.digest.Blake2b.Blake2b512();
        byte[] digest = blake2b512.digest(input.getBytes());
        return Hex.toHexString(digest);
    }

}
