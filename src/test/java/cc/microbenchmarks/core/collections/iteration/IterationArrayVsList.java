package cc.microbenchmarks.core.collections.iteration;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;

import java.util.ArrayList;
import java.util.Iterator;
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
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS, batchSize = 1000)
@Measurement(iterations = 20, time = 1, timeUnit = TimeUnit.SECONDS, batchSize = 1000)
public class IterationArrayVsList {

    ArrayList<Integer> list;
    Integer[] array;

    @Setup
    public void init() {
        list = new ArrayList<>();
        list.add(100500);
        array = new Integer[] {100500};
    }

    @Benchmark
    public Integer iterateList() {
        int r = 0;
        for (Integer i : list) {
            r += i;
        }
        return r;
    }

    @Benchmark
    public Integer iterateListViaIterator() {
        int r = 0;
        Iterator<Integer> iter = list.iterator();
        while (iter.hasNext()) {
            r += iter.next();
        }
        return r;
    }

    @Benchmark
    public Integer iterateListViaIndex() {
        int r = 0;
        for (int i = 0; i < list.size(); i++) {
            r += list.get(i);
        }
        return r;
    }

    @Benchmark
    public Integer iterateArrays() {
        int r = 0;
        for (Integer i : array) {
            r += i;
        }
        return r;
    }


}
