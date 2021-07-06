package ru.baronessdev.other.benchmark.hash;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

public class SHA3 {

    @BenchmarkMode(Mode.AverageTime)
    @Warmup(iterations = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Benchmark
    public void SHA3_224() {
        ru.baronessdev.other.benchmark.hash.utils.hashes.sha3.SHA3.sha3_224(Constants.SAMPLE);
    }

    @BenchmarkMode(Mode.AverageTime)
    @Warmup(iterations = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Benchmark
    public void SHA3_256() {
        ru.baronessdev.other.benchmark.hash.utils.hashes.sha3.SHA3.sha3_256(Constants.SAMPLE);
    }

    @BenchmarkMode(Mode.AverageTime)
    @Warmup(iterations = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Benchmark
    public void SHA3_384() {
        ru.baronessdev.other.benchmark.hash.utils.hashes.sha3.SHA3.sha3_384(Constants.SAMPLE);
    }

    @BenchmarkMode(Mode.AverageTime)
    @Warmup(iterations = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Benchmark
    public void SHA3_512() {
        ru.baronessdev.other.benchmark.hash.utils.hashes.sha3.SHA3.sha3_512(Constants.SAMPLE);
    }
}
