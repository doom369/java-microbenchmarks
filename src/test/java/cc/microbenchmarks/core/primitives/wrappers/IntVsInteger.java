package cc.microbenchmarks.core.primitives.wrappers;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Threads;
import org.openjdk.jmh.annotations.Warmup;

import java.util.concurrent.TimeUnit;

/**
 * The Blynk Project.
 * Created by Dmitriy Dumanskiy.
 * Created on 13.12.16.
 */
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Fork(1)
@State(Scope.Thread)
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 20, time = 1, timeUnit = TimeUnit.SECONDS)
public class IntVsInteger {

    @Benchmark
    public void doNothing() {
    }

    @Benchmark
    public int initInt() {
        int i = 300;
        return i;
    }

    @Benchmark
    public Integer initExplicitInteger() {
        Integer i = new Integer(300);
        return i;
    }

    @Benchmark
    public Integer initImplicitInteger() {
        Integer i = 300;
        return i;
    }

    @Benchmark
    public Integer initIntegerCached() {
        Integer i = 100;
        return i;
    }


}
