package ru.baronessdev.other.benchmark.hash;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

public class Tiger {

    @BenchmarkMode(Mode.AverageTime)
    @Warmup(iterations = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Benchmark
    public void Tiger_1() {
        ru.baronessdev.other.benchmark.hash.utils.hashes.tiger.Tiger.tiger(Constants.SAMPLE);
    }

    @BenchmarkMode(Mode.AverageTime)
    @Warmup(iterations = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Benchmark
    public void Tiger_2() {
        ru.baronessdev.other.benchmark.hash.utils.hashes.tiger.Tiger.tiger2(Constants.SAMPLE);
    }

    @BenchmarkMode(Mode.AverageTime)
    @Warmup(iterations = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Benchmark
    public void Tiger_128() {
        ru.baronessdev.other.benchmark.hash.utils.hashes.tiger.Tiger.tiger128(Constants.SAMPLE);
    }

    @BenchmarkMode(Mode.AverageTime)
    @Warmup(iterations = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Benchmark
    public void Tiger_160() {
        ru.baronessdev.other.benchmark.hash.utils.hashes.tiger.Tiger.tiger160(Constants.SAMPLE);
    }
}
