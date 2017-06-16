package cc.microbenchmarks.core.string.stringbuilder1;

import org.openjdk.jmh.annotations.*;

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
public class BuilderVsRegular3Concat {

    @Param({"Some Another Char sequence2"})
    String line;
    @Param({"Some String"})
    private String s;

    @Benchmark
    public String builderWithLength() {
        return new StringBuilder(s.length() + 1 + line.length())
                .append(String.valueOf(s))
                .append(' ')
                .append(line)
                .toString();
    }

    @Benchmark
    public String builder() {
        return new StringBuilder()
                .append(String.valueOf(s))
                .append(' ')
                .append(line)
                .toString();
    }

    @Benchmark
    public String naiveWithLocalVariable() {
        String loc = String.valueOf(s);
        return loc + ' ' + line;
    }

}
