package cc.microbenchmarks.core.arrays.boundscheck;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

/**
 * The Blynk Project.
 * Created by Dmitriy Dumanskiy.
 * Created on 13.12.16.
 */
@BenchmarkMode(Mode.Throughput)
@Fork(1)
@State(Scope.Thread)
@Warmup(iterations = 10, time = 1, timeUnit = TimeUnit.SECONDS, batchSize = 1000)
@Measurement(iterations = 20, time = 1, timeUnit = TimeUnit.SECONDS, batchSize = 1000)
public class BoundsCheck {

    @Param("1")
    int index;
    int[] ar;

    @Setup
    public void setup() {
        ar = new int[] {1, 2};
    }

    @Benchmark
    public int boundCheck() {
        if (index >= ar.length) {
           throw new IndexOutOfBoundsException();
        }
        return ar[index];
    }

    @Benchmark
    public int noCheck() {
        return ar[index];
    }

    @Benchmark
    public int noCheckWithTryCatch() {
        try {
            return ar[index];
        } catch (RuntimeException e) {
            return -1;
        }
    }
}
