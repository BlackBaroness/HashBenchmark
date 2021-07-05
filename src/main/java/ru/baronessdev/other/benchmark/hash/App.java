package ru.baronessdev.other.benchmark.hash;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.google.common.hash.Hashing;
import org.openjdk.jmh.annotations.*;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeUnit;

public class App {

    @BenchmarkMode(Mode.AverageTime)
    @Warmup(iterations = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Benchmark
    @SuppressWarnings("all")
    public void MD5() {
        Hashing.md5().hashString("123abc", StandardCharsets.UTF_8).toString();
    }

    @BenchmarkMode(Mode.AverageTime)
    @Warmup(iterations = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Benchmark
    @SuppressWarnings("all")
    public void SHA1() {
        Hashing.sha1().hashString("123abc", StandardCharsets.UTF_8).toString();
    }

    @BenchmarkMode(Mode.AverageTime)
    @Warmup(iterations = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Benchmark
    @SuppressWarnings("all")
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
    @SuppressWarnings("all")
    public void SHA256() {
        Hashing.sha256().hashString("123abc", StandardCharsets.UTF_8).toString();
    }

    @BenchmarkMode(Mode.AverageTime)
    @Warmup(iterations = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Benchmark
    @SuppressWarnings("all")
    public void SHA384() {
        Hashing.sha384().hashString("123abc", StandardCharsets.UTF_8).toString();
    }

    @BenchmarkMode(Mode.AverageTime)
    @Warmup(iterations = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Benchmark
    @SuppressWarnings("all")
    public void SHA512() {
        Hashing.sha512().hashString("123abc", StandardCharsets.UTF_8).toString();
    }

    @BenchmarkMode(Mode.AverageTime)
    @Warmup(iterations = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Benchmark
    @SuppressWarnings("all")
    public void BCrypt() {
        BCrypt.withDefaults().hashToString(12, "123abc".toCharArray());
    }
}
