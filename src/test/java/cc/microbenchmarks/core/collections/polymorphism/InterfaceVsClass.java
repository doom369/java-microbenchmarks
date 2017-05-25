package cc.microbenchmarks.core.collections.polymorphism;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * The Blynk Project.
 * Created by Dmitriy Dumanskiy.
 * Created on 12.02.17.UPdate
 */
@BenchmarkMode(Mode.Throughput)
@Fork(1)
@State(Scope.Thread)
@Warmup(iterations = 10, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 40, time = 1, timeUnit = TimeUnit.SECONDS)
public class InterfaceVsClass {

    List<Integer> list;
    ArrayList<Integer> arrayList;

    @Setup
    public void init() {
        list = new ArrayList<>();
        list.add(100500);
        arrayList = new ArrayList<>();
        arrayList.add(100500);
    }

    @Benchmark
    public Integer listGet() {
        return list.get(0);
    }

    @Benchmark
    public Integer arrayListGet() {
        return arrayList.get(0);
    }

}
