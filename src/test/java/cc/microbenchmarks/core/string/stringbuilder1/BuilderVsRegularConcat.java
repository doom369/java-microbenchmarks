package cc.microbenchmarks.core.string.stringbuilder1;

import org.openjdk.jmh.annotations.*;

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
@Warmup(iterations = 5, time = 1)
@Measurement(iterations = 5, time = 1)
public class BuilderVsRegularConcat {

    CharSequence value;

    @Param({"Some Another Char sequence2"})
    String line;

    @Setup
    public void seupt() {
        value = "Some Char sequence";
    }

    @Benchmark
    public String builder() {
        StringBuilder buf = new StringBuilder(value.length() + line.length() + 1);
        buf.append(value)
                .append(' ')
                .append(line);
        return buf.toString();
    }

    @Benchmark
    public String naiveWithLocalVariable() {
        String loc = String.valueOf(value);
        return loc + ' ' + line;
    }

    @Benchmark
    public String naive() {
        return String.valueOf(value) + ' ' + line;
    }

    @Benchmark
    public String naive2() {
        return "" + value + ' ' + line;
    }

    @Benchmark
    public String joiner() {
        return new StringJoiner(" ").add(value).add(line).toString();
    }

}
