package cc.microbenchmarks.core.ternary;

import org.openjdk.jmh.annotations.*;

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
@Measurement(iterations = 40, timeUnit = TimeUnit.NANOSECONDS)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class TernaryOperatorTest {

    @Param("1")
    private int param1;
    @Param("2")
    private int param2;

    @Benchmark
    public int ternaryOperator() {
        return param1 > param2 ? 10 : 5;
    }

    @Benchmark
    public int ifOperator() {
        if (param1 > param2) {
            return 10;
        } else {
            return 5;
        }
    }

}
