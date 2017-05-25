package cc.microbenchmarks.core.string.switch_vs_if;

import org.openjdk.jmh.annotations.*;

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
@Warmup(iterations = 10, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 20, time = 1, timeUnit = TimeUnit.SECONDS)
public class SwitchVsStartWithString {

    @Param({"/getSomething"})
    String uri;


    @Benchmark
    public String switchExample() {
        switch (uri) {
            case "/getSomething" :
                return "getSomething";
            case "/json" :
                return "json";
            default:
                return "";
        }
    }

    @Benchmark
    public String equals() {
        if (uri.equals("/getSomething")) {
            return "getSomething";
        } else if (uri.equals("/json")) {
            return "json";
        }
        return "";
    }

    @Benchmark
    public String startWith() {
        if (uri.startsWith("/getSomething")) {
            return "getSomething";
        } else if (uri.startsWith("/json")) {
            return "json";
        }
        return "";
    }

}
