package cc.microbenchmarks.core.arrays.emptyarray;

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
@Measurement(iterations = 40, time = 1, timeUnit = TimeUnit.SECONDS, batchSize = 1000)
public class EmptyArray {

    private static final String[] EMPTY = {};

    @Benchmark
    public B preAllocatedArray() {
        return new B();
    }

    @Benchmark
    public A newArrayAllocation() {
        return new A();
    }

    private class A {
        private String[] devices = {};
    }

    private class B {
        private String[] devices = EMPTY;
    }


}
