package ru.baronessdev.other.benchmark.hash.utils.hashes.ripemd;

import jonelo.jacksum.JacksumAPI;
import jonelo.jacksum.algorithm.AbstractChecksum;

import java.security.NoSuchAlgorithmException;

public class RIPEMD {


    private static String jacksumAPI(String input, String instance) {
        String output = "";
        AbstractChecksum abstractChecksum;
        try {
            abstractChecksum = JacksumAPI.getChecksumInstance(instance.toLowerCase());
            abstractChecksum.update(input.getBytes());
            output = abstractChecksum.getFormattedValue();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return output;
    }

    public static String ripemd128(String input) {
        return jacksumAPI(input, "RIPEMD-128");
    }

    public static String ripemd160(String input) {
        return jacksumAPI(input, "RIPEMD-160");
    }

    public static String ripemd256(String input) {
        return jacksumAPI(input, "RIPEMD-256");
    }

    public static String ripemd320(String input) {
        return jacksumAPI(input, "RIPEMD-320");
    }

}
