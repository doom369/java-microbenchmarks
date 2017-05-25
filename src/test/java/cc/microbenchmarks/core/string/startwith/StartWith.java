package cc.microbenchmarks.core.string.startwith;

import org.openjdk.jmh.annotations.*;

import java.util.Date;
import java.util.concurrent.TimeUnit;

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
public class StartWith {

    String a1 = "/myServletUrl".toLowerCase();
    String a2 = "/myWrongServletUrl";

    @Setup
    public void setup() {
        Date date;
    }

    @Benchmark
    public boolean startWithToLowerCase() {
        return a1.startsWith(a2.toLowerCase());
    }

    @Benchmark
    public boolean regionMatch() {
        return a1.regionMatches(true, 0, a2, 0, a1.length());
    }

}
