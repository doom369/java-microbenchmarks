package cc.microbenchmarks.core.string;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
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
public class BuilderVsRegularConcat3 {

    public static final char DEVICE_SEPARATOR = '-';

    @Param({"111"})
    int dashId;

    @Param({"222"})
    int deviceId;


    @Benchmark
    public String builder() {
        String dashIdS = String.valueOf(dashId);
        String deviceIdS = String.valueOf(deviceId);
        StringBuilder buf = new StringBuilder(dashIdS.length() + deviceIdS.length() + 1);
        buf.append(dashIdS)
                .append(DEVICE_SEPARATOR)
                .append(deviceIdS);
        return buf.toString();
    }

    @Benchmark
    public String naive() {
        return "" + dashId + DEVICE_SEPARATOR + deviceId;
    }

    @Benchmark
    public String naive2() {
        return String.valueOf(dashId) + DEVICE_SEPARATOR + deviceId;
    }

}
