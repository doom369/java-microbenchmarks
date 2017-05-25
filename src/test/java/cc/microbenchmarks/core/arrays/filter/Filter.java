package cc.microbenchmarks.core.arrays.filter;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;

import java.util.ArrayList;
import java.util.Arrays;
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
public class Filter {

    private int[] ar = new int[] {1,2,3,4,5,6,7};

    @Benchmark
    public int[] naive() {
        return greaterThan(ar);
    }

    @Benchmark
    public int[] lambdaIntStreamContains() {
        return IntStream.of(ar).filter(i -> i > 4).toArray();
    }

    private static int[] greaterThan(int[] ar) {
        int[] l = new int[ar.length];
        for (int i = 0; i < ar.length; i++) {
            int arVal = ar[i];
            if (arVal > 4) {
                l[i] = arVal;
            }
        }
        return l;
    }

}
