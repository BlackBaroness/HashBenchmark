package ru.baronessdev.other.benchmark.hash.utils.hashes.tiger;

import jonelo.jacksum.JacksumAPI;
import jonelo.jacksum.algorithm.AbstractChecksum;

import java.security.NoSuchAlgorithmException;

public class Tiger {


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

    public static String tiger(String input) {
        return jacksumAPI(input, "Tiger");
    }

    public static String tiger2(String input) {
        return jacksumAPI(input, "Tiger2");
    }

    public static String tiger128(String input) {
        return jacksumAPI(input, "Tiger-128");
    }

    public static String tiger160(String input) {
        return jacksumAPI(input, "Tiger-160");
    }
}
