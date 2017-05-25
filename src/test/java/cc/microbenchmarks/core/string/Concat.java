package cc.microbenchmarks.core.string;

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

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

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
public class Concat {

    public static final String BODY_SEPARATOR_STRING = String.valueOf("\0");

    char a;
    String aS;
    byte b;
    String pin;

    @Setup
    public void prepare() {
        a = 'a';
        aS = "a";
        b = 100;
        pin = "100";
    }

    @Benchmark
    public String emptyString() {
        return makeHardwareBody(a, b, "Some String");
    }

    @Benchmark
    public String stringConcat() {
        return makeHardwareBody(aS, b, "Some String");
    }

    @Benchmark
    public String stringConcatStringPin() {
        return makeHardwareBody(a, pin, "Some String");
    }

    @Benchmark
    public String stringConcatStringPinManual() {
        return makeHardwareBody(a, String.valueOf(b), "Some String");
    }

    public static String makeHardwareBody(char pinType, byte pin, String value) {
        return "" + pinType + 'w'
                + BODY_SEPARATOR_STRING + pin
                + BODY_SEPARATOR_STRING + value;
    }

    public static String makeHardwareBody(String pinType, byte pin, String value) {
        return pinType + 'w'
                + BODY_SEPARATOR_STRING + pin
                + BODY_SEPARATOR_STRING + value;
    }

    public static String makeHardwareBody(char pinType, String pin, String value) {
        return "" + pinType + 'w'
                + BODY_SEPARATOR_STRING + pin
                + BODY_SEPARATOR_STRING + value;
    }

}
