package cc.microbenchmarks.core.arrays.contains;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * The Blynk Project.
 * Created by Dmitriy Dumanskiy.
 * Created on 13.12.16.
 */
@BenchmarkMode(Mode.Throughput)
@Fork(1)
@State(Scope.Thread)
@Warmup(iterations = 10, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 10, time = 1, timeUnit = TimeUnit.SECONDS)
public class Contains {

    private int[] ar;
    private int val;

    @Setup
    public void setup() {
        val = 5;
        ar = new int[] {1,-32,1,1,5,6,7};
    }

    @Benchmark
    public boolean naive() {
        return contains(ar, val);
    }

    @Benchmark
    public boolean lambdaArrayStreamContains() {
        return Arrays.stream(ar).anyMatch(i -> i == val);
    }

    @Benchmark
    public boolean lambdaIntStreamContains() {
        return IntStream.of(ar).anyMatch(i -> i == val);
    }

    private static boolean contains(int[] ar, int value) {
        for (int arVal : ar) {
            if (arVal == value) {
                return true;
            }
        }
        return false;
    }

}
