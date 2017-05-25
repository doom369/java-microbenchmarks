package cc.microbenchmarks.core.primitives.unboxing;

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
public class IntCasting {

    int iPrimitive;
    Integer iWrapper;

    @Setup
    public void prepare() {
        //cast operation is very very cheap, so we have to init variable before benchmark
        iPrimitive = 300;
        iWrapper = 300;
    }


    @Benchmark
    public int intReturnNoAutoBoxing() {
        return iPrimitive;
    }

    @Benchmark
    public Integer intReturnAutoBoxing() {
        //hidden autoboxing happens here
        return iPrimitive;
    }

    @Benchmark
    public Integer integerReturnNoUnboxing() {
        return iWrapper;
    }

    @Benchmark
    public int integerReturnUnboxing() {
        //hidden unboxing happens here
        return iWrapper;
    }





}
