package ru.baronessdev.other.benchmark.hash.utils.hashes.sha3;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Hex;

import java.security.Security;

public class SHA3 {

    // Provider
    static {
        Security.insertProviderAt(new BouncyCastleProvider(), 1);
    }


    /**
     * Source code:
     * https://github.com/rtyley/spongycastle/blob/spongy-master/core/src/main/java/org/spongycastle/crypto/digests/SHA3Digest.java
     *
     * @param input string
     * @return Hash string
     */
    public static String sha3_224(final String input) {
        org.bouncycastle.jcajce.provider.digest.SHA3.DigestSHA3 sha3 = new org.bouncycastle.jcajce.provider.digest.SHA3.Digest224();
        byte[] digest = sha3.digest(input.getBytes());
        return Hex.toHexString(digest);
    }

    /**
     * Source code:
     * https://github.com/rtyley/spongycastle/blob/spongy-master/core/src/main/java/org/spongycastle/crypto/digests/SHA3Digest.java
     *
     * @param input string
     * @return Hash string
     */
    public static String sha3_256(final String input) {
        org.bouncycastle.jcajce.provider.digest.SHA3.DigestSHA3 sha3 = new org.bouncycastle.jcajce.provider.digest.SHA3.Digest256();
        byte[] digest = sha3.digest(input.getBytes());
        return Hex.toHexString(digest);
    }

    /**
     * Source code:
     * https://github.com/rtyley/spongycastle/blob/spongy-master/core/src/main/java/org/spongycastle/crypto/digests/SHA3Digest.java
     *
     * @param input string
     * @return Hash string
     */
    public static String sha3_384(final String input) {
        org.bouncycastle.jcajce.provider.digest.SHA3.DigestSHA3 sha3 = new org.bouncycastle.jcajce.provider.digest.SHA3.Digest384();
        byte[] digest = sha3.digest(input.getBytes());
        return Hex.toHexString(digest);
    }

    /**
     * Source code:
     * https://github.com/rtyley/spongycastle/blob/spongy-master/core/src/main/java/org/spongycastle/crypto/digests/SHA3Digest.java
     *
     * @param input string
     * @return Hash string
     */
    public static String sha3_512(final String input) {
        org.bouncycastle.jcajce.provider.digest.SHA3.DigestSHA3 sha3 = new org.bouncycastle.jcajce.provider.digest.SHA3.Digest512();
        byte[] digest = sha3.digest(input.getBytes());
        return Hex.toHexString(digest);
    }

}
