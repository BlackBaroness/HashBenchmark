package ru.baronessdev.other.benchmark.hash;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

public class BLAKE2B {

    @BenchmarkMode(Mode.AverageTime)
    @Warmup(iterations = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Benchmark
    public void BLAKE2B_160() {
        ru.baronessdev.other.benchmark.hash.utils.hashes.blake2b.Blake2b.blake2b160(Constants.SAMPLE);
    }

    @BenchmarkMode(Mode.AverageTime)
    @Warmup(iterations = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Benchmark
    public void BLAKE2B_256() {
        ru.baronessdev.other.benchmark.hash.utils.hashes.blake2b.Blake2b.blake2b256(Constants.SAMPLE);
    }

    @BenchmarkMode(Mode.AverageTime)
    @Warmup(iterations = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Benchmark
    public void BLAKE2B_384() {
        ru.baronessdev.other.benchmark.hash.utils.hashes.blake2b.Blake2b.blake2b384(Constants.SAMPLE);
    }

    @BenchmarkMode(Mode.AverageTime)
    @Warmup(iterations = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Benchmark
    public void BLAKE2B_512() {
        ru.baronessdev.other.benchmark.hash.utils.hashes.blake2b.Blake2b.blake2b512(Constants.SAMPLE);
    }


}
