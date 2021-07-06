package ru.baronessdev.other.benchmark.hash.utils.hashes.adler;

import jonelo.jacksum.JacksumAPI;
import jonelo.jacksum.algorithm.AbstractChecksum;

import java.security.NoSuchAlgorithmException;

public class Adler {


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

    public static String adler32(String input) {
        return jacksumAPI(input, "Adler32");
    }

}
