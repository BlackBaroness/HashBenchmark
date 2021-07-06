package ru.baronessdev.other.benchmark.hash;

import org.openjdk.jmh.annotations.*;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeUnit;

public class SHA {

    @BenchmarkMode(Mode.AverageTime)
    @Warmup(iterations = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Benchmark
    public void SHA0() {
        ru.baronessdev.other.benchmark.hash.utils.hashes.sha.SHA.sha0(Constants.SAMPLE);
    }

    @BenchmarkMode(Mode.AverageTime)
    @Warmup(iterations = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Benchmark
    public void SHA1() {
        ru.baronessdev.other.benchmark.hash.utils.hashes.sha.SHA.sha1(Constants.SAMPLE);
    }

    @BenchmarkMode(Mode.AverageTime)
    @Warmup(iterations = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Benchmark
    public void SHA224() {
        ru.baronessdev.other.benchmark.hash.utils.hashes.sha.SHA.sha224(Constants.SAMPLE);
    }

    @BenchmarkMode(Mode.AverageTime)
    @Warmup(iterations = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Benchmark
    public void SHA256() {
        ru.baronessdev.other.benchmark.hash.utils.hashes.sha.SHA.sha256(Constants.SAMPLE);
    }

    @BenchmarkMode(Mode.AverageTime)
    @Warmup(iterations = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Benchmark
    public void SHA384() {
        ru.baronessdev.other.benchmark.hash.utils.hashes.sha.SHA.sha384(Constants.SAMPLE);
    }

    @BenchmarkMode(Mode.AverageTime)
    @Warmup(iterations = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Benchmark
    public void SHA512() {
        ru.baronessdev.other.benchmark.hash.utils.hashes.sha.SHA.sha512(Constants.SAMPLE);
    }
}
