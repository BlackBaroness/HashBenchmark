package ru.baronessdev.other.benchmark.hash.utils.ciphers.cast;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.engines.CAST5Engine;
import org.bouncycastle.crypto.engines.CAST6Engine;
import org.bouncycastle.crypto.modes.CBCBlockCipher;
import org.bouncycastle.crypto.paddings.PaddedBufferedBlockCipher;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import ru.baronessdev.other.benchmark.hash.utils.Mode;

import java.nio.charset.StandardCharsets;
import java.security.Security;

public class CAST {


    // Provider
    static {
        Security.insertProviderAt(new BouncyCastleProvider(), 1);
    }

    /**
     * Source code:
     * https://github.com/rtyley/spongycastle/blob/spongy-master/core/src/main/java/org/spongycastle/crypto/engines/CAST5Engine.java
     * See also:
     * https://github.com/rtyley/spongycastle/blob/spongy-master/core/src/main/java/org/spongycastle/crypto/BufferedBlockCipher.java
     * Modes:
     * https://github.com/rtyley/spongycastle/blob/spongy-master/core/src/main/java/org/spongycastle/crypto/modes/CBCBlockCipher.java
     * Wiki:
     * https://en.wikipedia.org/wiki/Block_cipher_mode_of_operation#Cipher_block_chaining_(CBC)
     *
     * @param mode  cipher mode
     * @param input string
     * @param key   cipher key
     * @return Hash string
     */
    public static String cast5(Mode mode, String input, String key) {
        org.apache.commons.codec.binary.Base64 base64 = new org.apache.commons.codec.binary.Base64();
        try {
            if (mode == Mode.ENCRYPT) {
                BlockCipher engine = new CAST5Engine();

                BufferedBlockCipher cipher = new PaddedBufferedBlockCipher(new CBCBlockCipher(engine));
                cipher.init(true, new KeyParameter(key.getBytes(StandardCharsets.UTF_8)));

                byte[] inputBytes = input.getBytes(StandardCharsets.UTF_8);
                byte[] rv = new byte[cipher.getOutputSize(inputBytes.length)];
                int numOutBytes = cipher.processBytes(inputBytes, 0, inputBytes.length, rv, 0);

                cipher.doFinal(rv, numOutBytes);
                return base64.encodeToString(rv);
            }

            if (mode == Mode.DECRYPT) {
                BlockCipher engine = new CAST5Engine();

                BufferedBlockCipher cipher = new PaddedBufferedBlockCipher(new CBCBlockCipher(engine));
                cipher.init(false, new KeyParameter(key.getBytes(StandardCharsets.UTF_8)));

                byte[] inputBytes = base64.decode(input.getBytes(StandardCharsets.UTF_8));
                byte[] rv = new byte[cipher.getOutputSize(inputBytes.length)];
                int numOutBytes = cipher.processBytes(inputBytes, 0, inputBytes.length, rv, 0);

                cipher.doFinal(rv, numOutBytes);
                return new String(rv, StandardCharsets.UTF_8).replaceAll("\u0000.*", "");
            }
        } catch (DataLengthException | IllegalStateException | InvalidCipherTextException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    /**
     * Source code:
     * https://github.com/rtyley/spongycastle/blob/spongy-master/core/src/main/java/org/spongycastle/crypto/engines/CAST6Engine.java
     * See also:
     * https://github.com/rtyley/spongycastle/blob/spongy-master/core/src/main/java/org/spongycastle/crypto/BufferedBlockCipher.java
     * Modes:
     * https://github.com/rtyley/spongycastle/blob/spongy-master/core/src/main/java/org/spongycastle/crypto/modes/CBCBlockCipher.java
     *
     * @param mode  cipher mode
     * @param input string
     * @param key   cipher key
     * @return Hash string
     */
    public static String cast6(Mode mode, String input, String key) {
        org.apache.commons.codec.binary.Base64 base64 = new org.apache.commons.codec.binary.Base64();
        try {
            if (mode == Mode.ENCRYPT) {
                BlockCipher engine = new CAST6Engine();

                BufferedBlockCipher cipher = new PaddedBufferedBlockCipher(new CBCBlockCipher(engine));
                cipher.init(true, new KeyParameter(key.getBytes(StandardCharsets.UTF_8)));

                byte[] inputBytes = input.getBytes(StandardCharsets.UTF_8);
                byte[] rv = new byte[cipher.getOutputSize(inputBytes.length)];
                int numOutBytes = cipher.processBytes(inputBytes, 0, inputBytes.length, rv, 0);

                cipher.doFinal(rv, numOutBytes);
                return base64.encodeToString(rv);
            }

            if (mode == Mode.DECRYPT) {
                BlockCipher engine = new CAST6Engine();

                BufferedBlockCipher cipher = new PaddedBufferedBlockCipher(new CBCBlockCipher(engine));
                cipher.init(false, new KeyParameter(key.getBytes(StandardCharsets.UTF_8)));

                byte[] inputBytes = base64.decode(input.getBytes(StandardCharsets.UTF_8));
                byte[] rv = new byte[cipher.getOutputSize(inputBytes.length)];
                int numOutBytes = cipher.processBytes(inputBytes, 0, inputBytes.length, rv, 0);

                cipher.doFinal(rv, numOutBytes);
                return new String(rv, StandardCharsets.UTF_8).replaceAll("\u0000.*", "");
            }
        } catch (DataLengthException | IllegalStateException | InvalidCipherTextException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

}
