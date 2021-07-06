package ru.baronessdev.other.benchmark.hash;

import com.google.common.hash.Hashing;
import org.openjdk.jmh.annotations.*;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

@SuppressWarnings({"UnstableApiUsage", "ResultOfMethodCallIgnored"})
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
        Hashing.md5().hashString(Constants.SAMPLE, StandardCharsets.UTF_8);
    }
}
