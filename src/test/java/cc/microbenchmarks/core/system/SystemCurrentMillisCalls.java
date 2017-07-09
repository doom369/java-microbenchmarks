package cc.microbenchmarks.core.system;

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
@Warmup(iterations = 10, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 10, time = 1, timeUnit = TimeUnit.SECONDS)
public class SystemCurrentMillisCalls {

    @Benchmark
    public long curr() {
        return System.currentTimeMillis();
    }

    @Benchmark
    public long instant() {
        return Instant.now().toEpochMilli();
    }



}
