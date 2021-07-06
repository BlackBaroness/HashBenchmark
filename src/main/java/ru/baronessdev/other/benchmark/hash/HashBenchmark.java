package ru.baronessdev.other.benchmark.hash;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.google.common.hash.Hashing;
import fr.cryptohash.JCAProvider;
import io.lktk.NativeBLAKE3;
import org.openjdk.jmh.annotations.*;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeUnit;

@SuppressWarnings("all")
public class HashBenchmark {

    @BenchmarkMode(Mode.AverageTime)
    @Warmup(iterations = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Benchmark
    public void MD5() {
        Hashing.md5().hashString("123abc", StandardCharsets.UTF_8).toString();
    }

    @BenchmarkMode(Mode.AverageTime)
    @Warmup(iterations = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Benchmark
    public void SHA1() {
        Hashing.sha1().hashString("123abc", StandardCharsets.UTF_8).toString();
    }

    @BenchmarkMode(Mode.AverageTime)
    @Warmup(iterations = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Benchmark
    public void SHA224() {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-224");
            byte[] messageDigest = md.digest("123abc".getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            StringBuilder hashText = new StringBuilder(no.toString(16));

            while (hashText.length() < 32) {
                hashText.insert(0, "0");
            }
        } catch (NoSuchAlgorithmException ignored) {
        }
    }

    @BenchmarkMode(Mode.AverageTime)
    @Warmup(iterations = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Benchmark
    public void SHA256() {
        Hashing.sha256().hashString("123abc", StandardCharsets.UTF_8).toString();
    }

    @BenchmarkMode(Mode.AverageTime)
    @Warmup(iterations = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Benchmark
    public void SHA384() {
        Hashing.sha384().hashString("123abc", StandardCharsets.UTF_8).toString();
    }

    @BenchmarkMode(Mode.AverageTime)
    @Warmup(iterations = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Benchmark
    public void SHA512() {
        Hashing.sha512().hashString("123abc", StandardCharsets.UTF_8).toString();
    }

    @BenchmarkMode(Mode.AverageTime)
    @Warmup(iterations = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Benchmark
    public void BCrypt() {
        BCrypt.withDefaults().hashToString(12, "123abc".toCharArray());
    }



    /*     here is some charset problems with BLAKE so using UTF-16 and converting to UTF-8    */

    @BenchmarkMode(Mode.AverageTime)
    @Warmup(iterations = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Benchmark
    public void BLAKE3() {
        try {
            NativeBLAKE3 blake3 = new NativeBLAKE3();
            blake3.initDefault();
            blake3.update("123abc".getBytes(StandardCharsets.UTF_16));

            new String(
                    new String(blake3.getOutput(), StandardCharsets.UTF_16).getBytes(StandardCharsets.UTF_8),
                    StandardCharsets.UTF_8
            );
        } catch (Exception ignored) {
        }
    }


    @BenchmarkMode(Mode.AverageTime)
    @Warmup(iterations = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Benchmark
    public void BLAKE256() {
        try {
            MessageDigest mdSH = MessageDigest.getInstance("BLAKE256", new JCAProvider());
            mdSH.update("123abc".getBytes());
            new String(
                    new String(mdSH.digest(), StandardCharsets.UTF_16).getBytes(StandardCharsets.UTF_8),
                    StandardCharsets.UTF_8
            );
        } catch (Exception ignored) {
        }
    }

    @BenchmarkMode(Mode.AverageTime)
    @Warmup(iterations = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Benchmark
    public void BLAKE512() {
        try {
            MessageDigest mdSH = MessageDigest.getInstance("BLAKE512", new JCAProvider());
            mdSH.update("123abc".getBytes());
            new String(
                    new String(mdSH.digest(), StandardCharsets.UTF_16).getBytes(StandardCharsets.UTF_8),
                    StandardCharsets.UTF_8
            );
        } catch (Exception ignored) {
        }
    }

    @BenchmarkMode(Mode.AverageTime)
    @Warmup(iterations = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Benchmark
    public void CubeHash512() {
        try {
            MessageDigest mdSH = MessageDigest.getInstance("CubeHash512", new JCAProvider());
            mdSH.update("123abc".getBytes());

            // here is some charset problems so using UTF-16 and converting to UTF-8
            new String(
                    new String(mdSH.digest(), StandardCharsets.UTF_16).getBytes(StandardCharsets.UTF_8),
                    StandardCharsets.UTF_8
            );
        } catch (Exception ignored) {
        }
    }

    @BenchmarkMode(Mode.AverageTime)
    @Warmup(iterations = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Benchmark
    public void Whirlpool() {
        try {
            MessageDigest mdSH = MessageDigest.getInstance("Whirlpool", new JCAProvider());
            mdSH.update("123abc".getBytes());

            // here is some charset problems so using UTF-16 and converting to UTF-8
            new String(
                    new String(mdSH.digest(), StandardCharsets.UTF_16).getBytes(StandardCharsets.UTF_8),
                    StandardCharsets.UTF_8
            );
        } catch (Exception ignored) {
        }
    }
}
