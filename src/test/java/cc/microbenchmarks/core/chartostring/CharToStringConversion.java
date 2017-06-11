package cc.microbenchmarks.core.chartostring;

import org.openjdk.jmh.annotations.*;

import java.time.Instant;
import java.util.concurrent.TimeUnit;

/**
 * The Blynk Project.
 * Created by Dmitriy Dumanskiy.
 * Created on 12.02.17.
 */
@BenchmarkMode(Mode.Throughput)
@Fork(1)
@State(Scope.Thread)
@Warmup(iterations = 10, time = 1, batchSize = 1000, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 10, time = 1, batchSize = 1000, timeUnit = TimeUnit.SECONDS)
public class CharToStringConversion {

    private char c = 'c';

    @Benchmark
    public String stringValueOf() {
        return String.valueOf(c);
    }

    @Benchmark
    public String stringValueOfCharArray() {
        return String.valueOf(new char[]{c});
    }

    @Benchmark
    public String characterToString() {
        return Character.toString(c);
    }

    @Benchmark
    public String characterObjectToString() {
        return new Character(c).toString();
    }

    @Benchmark
    public String concatBlankStringPre() {
        return c + "";
    }

    @Benchmark
    public String concatBlankStringPost() {
        return "" + c;
    }

    @Benchmark
    public String fromCharArray() {
        return new String(new char[]{c});
    }
}
