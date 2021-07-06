package ru.baronessdev.other.benchmark.hash;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

public class Whirlpool {

    @BenchmarkMode(Mode.AverageTime)
    @Warmup(iterations = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Benchmark
    public void Whirlpool_0() {
        ru.baronessdev.other.benchmark.hash.utils.hashes.whirlpool.Whirlpool.whirlpool0(Constants.SAMPLE);
    }

    @BenchmarkMode(Mode.AverageTime)
    @Warmup(iterations = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Benchmark
    public void Whirlpool_1() {
        ru.baronessdev.other.benchmark.hash.utils.hashes.whirlpool.Whirlpool.whirlpool1(Constants.SAMPLE);
    }

    @BenchmarkMode(Mode.AverageTime)
    @Warmup(iterations = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Benchmark
    public void Whirlpool_2() {
        ru.baronessdev.other.benchmark.hash.utils.hashes.whirlpool.Whirlpool.whirlpool(Constants.SAMPLE);
    }
}
