package cc.microbenchmarks.core.equals;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.BenchmarkParams;
import org.openjdk.jmh.infra.Blackhole;

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
public class Equals {

    @Param({"", "Tag1", "Some String Tag", "Very Big and Long String Probably"})
    String strParams;

    @Param({"0", "1", "2", "3"})
    int intParams;

    @Benchmark
    public boolean nonExistingTag() {
        return strParams.equals("Non-Exist");
    }

    @Benchmark
    public boolean existingTag() {
        return strParams.equals("Some String Tag");
    }

    @Benchmark
    public boolean nonExistingIndex() {
        return 10 == intParams;
    }

    @Benchmark
    public boolean existingIndex() {
        return 1 == intParams;
    }

}
