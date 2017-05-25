package cc.microbenchmarks.core.string.concat;

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
@BenchmarkMode(Mode.Throughput)
@Fork(1)
@State(Scope.Thread)
@Warmup(iterations = 10, time = 1, timeUnit = TimeUnit.SECONDS, batchSize = 1000)
@Measurement(iterations = 40, time = 1, timeUnit = TimeUnit.SECONDS, batchSize = 1000)
public class StringConcatTest {

    private int aInt;

    @Setup
    public void prepare() {
        aInt = 100;
    }

    @Benchmark
    public String emptyStringInt() {
        return "" + aInt;
    }

    @Benchmark
    public String valueOfInt() {
        return String.valueOf(aInt);
    }

    @Benchmark
    public String valueOfStringBuilder() {
        return new StringBuilder().append(aInt).toString();
    }

    @Benchmark
    public String valueOfStringBuilderPreciseSize() {
        return new StringBuilder(3).append(aInt).toString();
    }

}
