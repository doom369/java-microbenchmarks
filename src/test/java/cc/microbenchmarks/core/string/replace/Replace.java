package cc.microbenchmarks.core.string.replace;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;

import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/**
 * The Blynk Project.
 * Created by Dmitriy Dumanskiy.
 * Created on 12.02.17.
 */
@BenchmarkMode(Mode.Throughput)
@Fork(1)
@State(Scope.Thread)
@Warmup(iterations = 10, time = 1, timeUnit = TimeUnit.SECONDS, batchSize = 1000)
@Measurement(iterations = 40, time = 1, timeUnit = TimeUnit.SECONDS, batchSize = 1000)
public class Replace {

    private static final Pattern PIN_PATTERN =  Pattern.compile("/pin/", Pattern.LITERAL);

    @Param("My temp is /pin/")
    String val;

    @Benchmark
    public String replaceAll() {
        return val.replaceAll("/pin/", "123");
    }

    @Benchmark
    public String replaceAllCachedPattern() {
        return PIN_PATTERN.matcher(val).replaceAll("123");
    }



}
