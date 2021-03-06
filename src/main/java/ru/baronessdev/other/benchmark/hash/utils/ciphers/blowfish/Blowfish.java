package ru.baronessdev.other.benchmark.hash.utils.ciphers.blowfish;

import ru.baronessdev.other.benchmark.hash.utils.Mode;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.GeneralSecurityException;

public class Blowfish {


    public static String blowfish(String input, Mode mode, String key) {
        String output = "";

        org.apache.commons.codec.binary.Base64 base64 = new org.apache.commons.codec.binary.Base64();
        byte[] keyBytes = key.getBytes();
        SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "Blowfish");

        if (mode == Mode.ENCRYPT) {
            try {
                Cipher cipher = Cipher.getInstance("Blowfish");
                cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
                output = base64.encodeToString(cipher.doFinal(input.getBytes()));
            } catch (GeneralSecurityException e) {
                e.printStackTrace();
            }
        }

        if (mode == Mode.DECRYPT) {
            try {
                Cipher cipher = Cipher.getInstance("Blowfish");
                cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
                output = new String(cipher.doFinal(base64.decode(input.getBytes())));
            } catch (GeneralSecurityException e) {
                e.printStackTrace();
            }
        }

        return output;
    }

}
