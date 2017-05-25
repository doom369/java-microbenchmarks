package cc.microbenchmarks.core.string;

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

import java.util.StringJoiner;
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
public class BuilderVsRegularConcat2 {

    @Param({"Some Char sequence"})
    String value;

    @Param({"Some Char sequence2"})
    String line;


    @Benchmark
    public String builder() {
        final String lineTrimmed = line.toString().trim();
        StringBuilder buf = new StringBuilder(value.length() + lineTrimmed.length() + 1);
        buf.append(value)
                .append(' ')
                .append(lineTrimmed);
        return buf.toString();
    }

    @Benchmark
    public String naive() {
        final String lineTrimmed = line.toString().trim();
        return String.valueOf(value) + ' ' + lineTrimmed;
    }

    @Benchmark
    public String naive2() {
        final String lineTrimmed = line.toString().trim();
        return "" + value + ' ' + lineTrimmed;
    }


}
