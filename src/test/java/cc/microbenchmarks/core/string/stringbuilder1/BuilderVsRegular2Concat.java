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
public class BuilderVsRegular2Concat {

    @Param({"Some Another Char sequence2"})
    String line;
    private A a;

    @Setup
    public void setup() {
        a = new A();
        a.a = "Some Text here";
    }

    @Benchmark
    public String builderWithLength() {
        return new StringBuilder(a.a.length() + 1 + line.length())
                .append(a.a)
                .append(' ')
                .append(line)
                .toString();
    }

    @Benchmark
    public String builder() {
        return new StringBuilder()
                .append(a.a)
                .append(' ')
                .append(line)
                .toString();
    }

    @Benchmark
    public String naiveWithLocalVariable() {
        String loc = a.a;
        return loc + ' ' + line;
    }

    private class A {
        private String a;
    }
}
