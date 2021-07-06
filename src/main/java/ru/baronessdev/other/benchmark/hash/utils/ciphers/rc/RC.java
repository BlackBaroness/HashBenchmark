package ru.baronessdev.other.benchmark.hash.utils.ciphers.rc;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.engines.RC2Engine;
import org.bouncycastle.crypto.engines.RC4Engine;
import org.bouncycastle.crypto.engines.RC6Engine;
import org.bouncycastle.crypto.modes.CBCBlockCipher;
import org.bouncycastle.crypto.paddings.PaddedBufferedBlockCipher;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import ru.baronessdev.other.benchmark.hash.utils.Mode;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

public class RC {


    // Provider
    static {
        Security.insertProviderAt(new BouncyCastleProvider(), 1);
    }

    /**
     * Source code:
     * https://github.com/rtyley/spongycastle/blob/spongy-master/core/src/main/java/org/spongycastle/crypto/engines/RC2Engine.java
     *
     * @param mode  cipher mode
     * @param input string
     * @param key   cipher key
     * @return Hash string
     */
    public static String rc2(Mode mode, String input, String key) {
        org.apache.commons.codec.binary.Base64 base64 = new org.apache.commons.codec.binary.Base64();
        try {
            if (mode == Mode.ENCRYPT) {
                SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8),
                        new RC2Engine().getAlgorithmName());
                Cipher cipher = Cipher.getInstance(new RC2Engine().getAlgorithmName());

                cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
                return base64.encodeToString(cipher.doFinal(input.getBytes(StandardCharsets.UTF_8)));
            }
            if (mode == Mode.DECRYPT) {
                SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8),
                        new RC2Engine().getAlgorithmName());
                Cipher cipher = Cipher.getInstance(new RC2Engine().getAlgorithmName());
                cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
                return new String(cipher.doFinal(base64.decode(input.getBytes(StandardCharsets.UTF_8))));
            }
        } catch (NoSuchAlgorithmException | BadPaddingException | NoSuchPaddingException | IllegalBlockSizeException
                | InvalidKeyException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    /**
     * Source code:
     * https://github.com/rtyley/spongycastle/blob/spongy-master/core/src/main/java/org/spongycastle/crypto/engines/RC4Engine.java
     *
     * @param mode  cipher mode
     * @param input string
     * @param key   cipher key
     * @return Hash string
     */
    public static String rc4(Mode mode, String input, String key) {
        org.apache.commons.codec.binary.Base64 base64 = new org.apache.commons.codec.binary.Base64();
        try {
            if (mode == Mode.ENCRYPT) {
                SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8),
                        new RC4Engine().getAlgorithmName());
                Cipher cipher = Cipher.getInstance(new RC4Engine().getAlgorithmName());

                cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
                return base64.encodeToString(cipher.doFinal(input.getBytes(StandardCharsets.UTF_8)));
            }
            if (mode == Mode.DECRYPT) {
                SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8),
                        new RC4Engine().getAlgorithmName());
                Cipher cipher = Cipher.getInstance(new RC4Engine().getAlgorithmName());
                cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
                return new String(cipher.doFinal(base64.decode(input.getBytes(StandardCharsets.UTF_8))));
            }
        } catch (NoSuchAlgorithmException | BadPaddingException | NoSuchPaddingException | IllegalBlockSizeException
                | InvalidKeyException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    /**
     * Source code:
     * https://github.com/rtyley/spongycastle/blob/spongy-master/core/src/main/java/org/spongycastle/crypto/engines/RC6Engine.java
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
    public static String rc6(Mode mode, String input, String key) {
        org.apache.commons.codec.binary.Base64 base64 = new org.apache.commons.codec.binary.Base64();

        try {

            if (mode == Mode.ENCRYPT) {
                BlockCipher engine = new RC6Engine();

                BufferedBlockCipher cipher = new PaddedBufferedBlockCipher(new CBCBlockCipher(engine));
                cipher.init(true, new KeyParameter(key.getBytes(StandardCharsets.UTF_8)));

                byte[] inputBytes = input.getBytes(StandardCharsets.UTF_8);
                byte[] rv = new byte[cipher.getOutputSize(inputBytes.length)];
                int numOutBytes = cipher.processBytes(inputBytes, 0, inputBytes.length, rv, 0);

                cipher.doFinal(rv, numOutBytes);
                return base64.encodeToString(rv);
            }

            if (mode == Mode.DECRYPT) {
                BlockCipher engine = new RC6Engine();

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
