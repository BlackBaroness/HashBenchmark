package ru.baronessdev.other.benchmark.hash.utils.ciphers.atbash;

import ru.baronessdev.other.benchmark.hash.utils.Mode;

public class Atbash {

    private static final String PLAIN = "abcdefghijklmnopqrstuvwxyz";
    private static final String CIPHER = "zyxwvutsrqponmlkjihgfedcba";


    /**
     * Atbash cipher
     *
     * @param inputText Text to cipher / decipher
     * @param mode      encrypt or decrypt mode
     * @return String based on selected mode
     */
    public static String atbash(String inputText, final Mode mode) {
        try {
            inputText = inputText.toLowerCase();
            String output = null;

            if (mode == Mode.ENCRYPT) {
                String encoded = stripInvalidCharacters(inputText).toLowerCase();
                StringBuilder cyphered = new StringBuilder();
                for (char c : encoded.toCharArray()) {
                    cyphered.append(applyCipher(c));
                }
                output = cyphered.toString();
            }

            if (mode == Mode.DECRYPT) {
                String encoded = stripInvalidCharacters(inputText).toLowerCase();
                StringBuilder deciphered = new StringBuilder();
                for (char c : encoded.toCharArray()) {
                    deciphered.append(applyCipher(c));
                }
                output = deciphered.toString();
            }

            return output;
        } catch (Exception e) {
            return e.toString();
        }
    }

    private static String stripInvalidCharacters(String input) {
        StringBuilder filteredValue = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                filteredValue.append(c);
            }
        }
        return filteredValue.toString();
    }

    private static char applyCipher(char input) {
        int idx = PLAIN.indexOf(input);
        return idx >= 0 ? CIPHER.toCharArray()[idx] : input;
    }

}
