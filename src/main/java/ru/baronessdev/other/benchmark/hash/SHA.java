package ru.baronessdev.other.benchmark.hash;

import com.google.common.hash.Hashing;
import org.openjdk.jmh.annotations.*;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

@SuppressWarnings({"UnstableApiUsage", "ResultOfMethodCallIgnored"})
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
        Hashing.sha1().hashString(Constants.SAMPLE, StandardCharsets.UTF_8);
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
        Hashing.sha256().hashString(Constants.SAMPLE, StandardCharsets.UTF_8);
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
        Hashing.sha512().hashString(Constants.SAMPLE, StandardCharsets.UTF_8);
    }


}
