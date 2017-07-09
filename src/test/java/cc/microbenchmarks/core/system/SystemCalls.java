package cc.microbenchmarks.core.system;

import org.openjdk.jmh.annotations.*;

import java.time.Clock;
import java.time.Instant;

/**
 * The Blynk Project.
 * Created by Dmitriy Dumanskiy.
 * Created on 12.02.17.
 */
@BenchmarkMode(Mode.Throughput)
@Fork(1)
@State(Scope.Thread)
@Warmup(iterations = 10, time = 1, batchSize = 1000)
@Measurement(iterations = 20, time = 1, batchSize = 1000)
public class SystemCalls {

    @Benchmark
    public long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    @Benchmark
    public long millis() {
        return Clock.systemUTC().millis();
    }

    @Benchmark
    public long nanoTime() {
        return System.nanoTime();
    }

    @Benchmark
    public long toEpochMilli() {
        return Instant.now().toEpochMilli();
    }

}
