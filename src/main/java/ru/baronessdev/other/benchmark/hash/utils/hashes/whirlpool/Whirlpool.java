package ru.baronessdev.other.benchmark.hash.utils.hashes.whirlpool;

import jonelo.jacksum.JacksumAPI;
import jonelo.jacksum.algorithm.AbstractChecksum;

import java.security.NoSuchAlgorithmException;

public class Whirlpool {


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

    public static String whirlpool0(String input) {
        return jacksumAPI(input, "Whirlpool-0");
    }

    public static String whirlpool1(String input) {
        return jacksumAPI(input, "Whirlpool-1");
    }

    public static String whirlpool(String input) {
        return jacksumAPI(input, "Whirlpool");
    }

}
