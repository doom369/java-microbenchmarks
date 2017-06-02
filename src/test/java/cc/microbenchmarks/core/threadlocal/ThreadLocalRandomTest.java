package cc.microbenchmarks.core.threadlocal;

import org.openjdk.jmh.annotations.*;

import java.time.Instant;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * The Blynk Project.
 * Created by Dmitriy Dumanskiy.
 * Created on 12.02.17.
 */
@BenchmarkMode(Mode.AverageTime)
@Fork(1)
@Threads(8)
@State(Scope.Thread)
@Warmup(iterations = 10, timeUnit = TimeUnit.NANOSECONDS)
@Measurement(iterations = 10, timeUnit = TimeUnit.NANOSECONDS)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class ThreadLocalRandomTest {

    @Benchmark
    public int curr() {
        return ThreadLocalRandom.current().nextInt();
    }




}
