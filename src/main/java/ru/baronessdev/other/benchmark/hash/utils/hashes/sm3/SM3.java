package ru.baronessdev.other.benchmark.hash.utils.hashes.sm3;

import org.bouncycastle.crypto.digests.SM3Digest;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Hex;

import java.security.Security;

public class SM3 {

    // Provider
    static {
        Security.insertProviderAt(new BouncyCastleProvider(), 1);
    }


    /**
     * Source code:
     * https://github.com/rtyley/spongycastle/blob/spongy-master/core/src/main/java/org/spongycastle/crypto/digests/SM3Digest.java
     *
     * @param input string
     * @return Hash string
     */
    public static String sm3Hash(final String input) {
        SM3Digest sm3Digest = new SM3Digest();
        sm3Digest.update(input.getBytes(), 0, input.length());
        byte[] result = new byte[sm3Digest.getDigestSize()];
        sm3Digest.doFinal(result, 0);
        return Hex.toHexString(result);
    }

}
