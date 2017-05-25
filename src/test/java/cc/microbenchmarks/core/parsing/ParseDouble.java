package cc.microbenchmarks.core.parsing;

import org.apache.commons.lang3.math.NumberUtils;
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
@BenchmarkMode(Mode.Throughput)
@Fork(1)
@State(Scope.Thread)
@Warmup(iterations = 10, time = 1, timeUnit = TimeUnit.SECONDS, batchSize = 1000)
@Measurement(iterations = 40, time = 1, timeUnit = TimeUnit.SECONDS, batchSize = 1000)
public class ParseDouble {

    @Param({"", "123.123", "123", "123.123 F", "p 123.123"})
    String strParams;

    @Benchmark
    public double parseDoubleWithConditions() {
        try {
            if (Character.isLetter(strParams.charAt(0))) {
                return 0.0D;
            }
            return Double.parseDouble(strParams);
        } catch (Exception nfe) {
            return 0.0D;
        }
    }

    @Benchmark
    public double parseDouble() {
        try {
            return Double.parseDouble(strParams);
        } catch (Exception nfe) {
            return 0.0D;
        }
    }

    @Benchmark
    public double parseDoubleAlternative() {
        try {
            return NumberParser.getDouble(strParams);
        } catch (Exception nfe) {
            return 0.0D;
        }
    }



}
