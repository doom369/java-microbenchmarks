package cc.microbenchmarks.core.arrays.arraycopy;

import org.openjdk.jmh.annotations.*;

import java.util.Arrays;

/**
 * The Blynk Project.
 * Created by Dmitriy Dumanskiy.
 * Created on 12.02.17.
 */
@BenchmarkMode(Mode.Throughput)
@Fork(1)
@State(Scope.Thread)
@Warmup(iterations = 10, time = 1, batchSize = 1000)
@Measurement(iterations = 10, time = 1, batchSize = 1000)
public class ArrayCopy {

    @Param({"1","5","10","100", "1000"})
    private int size;
    private int[] ar;

    @Setup
    public void setup() {
        ar = new int[size];
        for (int i = 0; i < size; i++) {
            ar[i] = i;
        }
    }

    @Benchmark
    public int[] SystemArrayCopy() {
        final int length = size;
        int[] result = new int[length];
        System.arraycopy(ar, 0, result, 0, length);
        return result;
    }

    @Benchmark
    public int[] javaArrayCopy() {
        final int length = size;
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = ar[i];
        }
        return result;
    }

    @Benchmark
    public int[] arraysCopyOf() {
        final int length = size;
        return Arrays.copyOf(ar, length);
    }

}
