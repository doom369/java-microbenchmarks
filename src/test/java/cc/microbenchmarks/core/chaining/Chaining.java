package cc.microbenchmarks.core.chaining;

import org.openjdk.jmh.annotations.*;

import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * The Blynk Project.
 * Created by Dmitriy Dumanskiy.
 * Created on 13.12.16.
 */
@BenchmarkMode(Mode.Throughput)
@Fork(1)
@State(Scope.Thread)
@Warmup(iterations = 10, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 40, time = 1, timeUnit = TimeUnit.SECONDS)
public class Chaining {

    private String a1 = "111";
    private String a2 = "222";
    private String a3 = "333";

    @Setup
    public void setup() {
    }

    @Benchmark
    public String typicalChaining() {
        return new StringBuilder().append(a1).append(a2).append(a3).toString();
    }

    @Benchmark
    public String noChaining() {
        StringBuilder sb = new StringBuilder();
        sb.append(a1);
        sb.append(a2);
        sb.append(a3);
        return sb.toString();
    }

}
