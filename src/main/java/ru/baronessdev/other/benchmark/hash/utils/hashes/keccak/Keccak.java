package ru.baronessdev.other.benchmark.hash.utils.hashes.keccak;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Hex;

import java.security.Security;

public class Keccak {


    // Provider
    static {
        Security.insertProviderAt(new BouncyCastleProvider(), 1);
    }

    /**
     * Source code:
     * https://github.com/rtyley/spongycastle/blob/spongy-master/core/src/main/java/org/spongycastle/crypto/digests/KeccakDigest.java
     *
     * @param input string
     * @return Hash string
     */
    public static String keccak_256(final String input) {
        org.bouncycastle.jcajce.provider.digest.Keccak.Digest256 digest256 = new org.bouncycastle.jcajce.provider.digest.Keccak.Digest256();
        byte[] digest = digest256.digest(input.getBytes());
        return Hex.toHexString(digest);
    }

    /**
     * Source code:
     * https://github.com/rtyley/spongycastle/blob/spongy-master/core/src/main/java/org/spongycastle/crypto/digests/KeccakDigest.java
     *
     * @param input string
     * @return Hash string
     */
    public static String keccak_384(final String input) {
        org.bouncycastle.jcajce.provider.digest.Keccak.Digest384 digest384 = new org.bouncycastle.jcajce.provider.digest.Keccak.Digest384();
        byte[] digest = digest384.digest(input.getBytes());
        return Hex.toHexString(digest);
    }

    /**
     * Source code:
     * https://github.com/rtyley/spongycastle/blob/spongy-master/core/src/main/java/org/spongycastle/crypto/digests/KeccakDigest.java
     *
     * @param input string
     * @return Hash string
     */
    public static String keccak_512(final String input) {
        org.bouncycastle.jcajce.provider.digest.Keccak.Digest512 digest512 = new org.bouncycastle.jcajce.provider.digest.Keccak.Digest512();
        byte[] digest = digest512.digest(input.getBytes());
        return Hex.toHexString(digest);
    }
}
