package cc.microbenchmarks.core.string.equals;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
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
public class EmptyStringEquals {

    @Param({""})
    private String strParams;

    @Benchmark
    public boolean isEmptyAndNotNull() {
        return strParams == null || strParams.isEmpty();
    }

    @Benchmark
    public boolean isEmpty() {
        return strParams.isEmpty();
    }

    @Benchmark
    public boolean equalsPost() {
        return strParams.equals("");
    }

    @Benchmark
    public boolean preEquals() {
        return "".equals(strParams);
    }

}
