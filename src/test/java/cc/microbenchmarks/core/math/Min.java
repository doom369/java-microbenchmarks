package cc.microbenchmarks.core.math;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
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
@Warmup(iterations = 10, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
public class Min {

    @Param({"11"})
    int x;

    @Param({"10"})
    int y;

    @Benchmark
    public int mathMin() {
        return Math.min(x, y);
    }

    @Benchmark
    public int naiveImplementation() {
        return min(x, y);
    }

    @Benchmark
    public int naiveImplementation2() {
        return min2(x, y);
    }

    public static int min(int a, int b) {
        return (a <= b) ? a : b;
    }

    public static int min2(int a, int b) {
        if (a <= b) {
            return a;
        }
        return b;
    }

}
