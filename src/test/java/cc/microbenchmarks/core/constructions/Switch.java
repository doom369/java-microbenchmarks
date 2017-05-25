package cc.microbenchmarks.core.constructions;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
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
public class Switch {

    @Param({"1", "2"})
    public int val1;

    @Benchmark
    public int switchWithOrderedSequence() {
        switch (val1) {
            case 0 :
                return 100;
            case 1 :
                return 101;
            case 2 :
                return 102;
            case 3 :
                return 103;
            case 4 :
                return 4;
            case 5 :
                return 5;
            case 6 :
                return 6;
            case 7 :
                return 7;
            case 8 :
                return 8;
            default:
                throw new RuntimeException("Non expected input.");
        }
    }

    @Benchmark
    public int switchWithRandomSequence() {
        switch (val1) {
            case -3 :
                return 100;
            case 1 :
                return 101;
            case 2 :
                return 102;
            case 3422 :
                return 103;
            case 33 :
                return 4;
            case 23423 :
                return 5;
            case 32423 :
                return 6;
            case 4455 :
                return 7;
            case 34234234 :
                return 8;
            default:
                throw new RuntimeException("Non expected input.");
        }
    }


}
