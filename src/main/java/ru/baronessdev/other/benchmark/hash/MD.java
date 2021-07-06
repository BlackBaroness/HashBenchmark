package ru.baronessdev.other.benchmark.hash;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

public class MD {

    @BenchmarkMode(Mode.AverageTime)
    @Warmup(iterations = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Benchmark
    public void MD2() {
        ru.baronessdev.other.benchmark.hash.utils.hashes.md.MD.md2(Constants.SAMPLE);
    }

    @BenchmarkMode(Mode.AverageTime)
    @Warmup(iterations = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Benchmark
    public void MD4() {
        ru.baronessdev.other.benchmark.hash.utils.hashes.md.MD.md4(Constants.SAMPLE);
    }

    @BenchmarkMode(Mode.AverageTime)
    @Warmup(iterations = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Benchmark
    public void MD5() {
        ru.baronessdev.other.benchmark.hash.utils.hashes.md.MD.md5(Constants.SAMPLE);
    }
}
