package cc.microbenchmarks.core.string;

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
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
public class ConcatSimple {

    public static final char DEVICE_SEPARATOR = '-';
    public static final String BODY_SEPARATOR_STRING = String.valueOf("\0");

    int a;
    int b;
    byte bb;
    char c;

    @Setup
    public void prepare() {
        a = 100;
        b = 200;
        c = 'a';
        bb = (byte) 200;
    }

    @Benchmark
    public String t1() {
        return "" + c + 'w' + DEVICE_SEPARATOR + bb + DEVICE_SEPARATOR + "Some Val";
    }

    @Benchmark
    public String t2() {
        return String.valueOf(c) + 'w' + BODY_SEPARATOR_STRING + bb + BODY_SEPARATOR_STRING + "Some Val";
    }


    /*
    @Benchmark
    public String EmptyStringEquals() {
        return "" + a;
    }

    @Benchmark
    public String emptyStringAndChar() {
        return "" + a + DEVICE_SEPARATOR + b;
    }


    @Benchmark
    public String valueOf() {
        return String.valueOf(a);
    }

    @Benchmark
    public String valueOfAndChar() {
        return String.valueOf(a) + DEVICE_SEPARATOR + b;
    }
    */

}
