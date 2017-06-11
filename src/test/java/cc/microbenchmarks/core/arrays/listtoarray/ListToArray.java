package cc.microbenchmarks.core.arrays.listtoarray;

import org.openjdk.jmh.annotations.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * The Blynk Project.
 * Created by Dmitriy Dumanskiy.
 * Created on 12.02.17.
 */
@BenchmarkMode(Mode.Throughput)
@Fork(1)
@State(Scope.Thread)
@Warmup(iterations = 10, time = 1, timeUnit = TimeUnit.SECONDS, batchSize = 1000)
@Measurement(iterations = 20, time = 1, timeUnit = TimeUnit.SECONDS, batchSize = 1000)
public class ListToArray {

    @Param({"1", "100", "10000", "100000"})
    int n;

    private List<Integer> list = new ArrayList<>();

    @Setup
    public void populateList() {
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
    }

    @Benchmark
    public Integer[] preSize() {
        return list.toArray(new Integer[n]);
    }

    @Benchmark
    public Integer[] resize() {
        return list.toArray(new Integer[0]);
    }


}
