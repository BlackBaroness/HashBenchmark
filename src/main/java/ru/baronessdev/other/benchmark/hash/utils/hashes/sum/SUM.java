package ru.baronessdev.other.benchmark.hash.utils.hashes.sum;

import jonelo.jacksum.JacksumAPI;
import jonelo.jacksum.algorithm.AbstractChecksum;

import java.security.NoSuchAlgorithmException;

public class SUM {


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

    public static String sum8(String input) {
        return jacksumAPI(input, "sum8");
    }

    public static String sum16(String input) {
        return jacksumAPI(input, "sum16");
    }

    public static String sum24(String input) {
        return jacksumAPI(input, "sum24");
    }

    public static String sum32(String input) {
        return jacksumAPI(input, "sum32");
    }

}
