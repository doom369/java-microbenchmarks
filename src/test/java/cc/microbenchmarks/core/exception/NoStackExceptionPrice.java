package cc.microbenchmarks.core.exception;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;

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
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
public class NoStackExceptionPrice {

    @Benchmark
    public int throwError() {
        try {
            return throwError(true);
        } catch (Exception e) {
            return 0;
        }
    }

    @Benchmark
    public int doNotthrowError() {
        try {
            return throwError(false);
        } catch (Exception e) {
            return 0;
        }
    }

    public static int throwError(boolean needToThrow) {
        if (needToThrow) {
            throw new OptimizedException("Some message", null, false, false);
        }
        return 0;
    }

    private static class OptimizedException extends RuntimeException {
        public OptimizedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
            super(message, cause, enableSuppression, writableStackTrace);
        }
    }

}
