package ru.baronessdev.other.benchmark.hash.utils.hashes.sha2;

import org.bouncycastle.jcajce.provider.digest.SHA224;
import org.bouncycastle.jcajce.provider.digest.SHA256;
import org.bouncycastle.jcajce.provider.digest.SHA384;
import org.bouncycastle.jcajce.provider.digest.SHA512;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Hex;

import java.security.Security;

public class SHA2 {

    // Provider
    static {
        Security.insertProviderAt(new BouncyCastleProvider(), 1);
    }

    /**
     * Source code:
     * https://github.com/rtyley/spongycastle/blob/spongy-master/core/src/main/java/org/spongycastle/crypto/digests/SHA224Digest.java
     *
     * @param input string
     * @return Hash string
     */
    public static String sha2_224(final String input) {
        SHA224.Digest sha224 = new SHA224.Digest();
        byte[] digest = sha224.digest(input.getBytes());
        return Hex.toHexString(digest);
    }

    /**
     * Source code:
     * https://github.com/rtyley/spongycastle/blob/spongy-master/core/src/main/java/org/spongycastle/crypto/digests/SHA256Digest.java
     *
     * @param input string
     * @return Hash string
     */
    public static String sha2_256(final String input) {
        SHA256.Digest sha256 = new SHA256.Digest();
        byte[] digest = sha256.digest(input.getBytes());
        return Hex.toHexString(digest);
    }

    /**
     * Source code:
     * https://github.com/rtyley/spongycastle/blob/spongy-master/core/src/main/java/org/spongycastle/crypto/digests/SHA384Digest.java
     *
     * @param input string
     * @return Hash string
     */
    public static String sha2_384(final String input) {
        SHA384.Digest sha384 = new SHA384.Digest();
        byte[] digest = sha384.digest(input.getBytes());
        return Hex.toHexString(digest);
    }

    /**
     * Source code:
     * https://github.com/rtyley/spongycastle/blob/spongy-master/core/src/main/java/org/spongycastle/crypto/digests/SHA512Digest.java
     *
     * @param input string
     * @return Hash string
     */
    public static String sha2_512(final String input) {
        SHA512.Digest sha512 = new SHA512.Digest();
        byte[] digest = sha512.digest(input.getBytes());
        return Hex.toHexString(digest);
    }

}
