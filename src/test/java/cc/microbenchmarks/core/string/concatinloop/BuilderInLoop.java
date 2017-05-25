package cc.microbenchmarks.core.string.concatinloop;

import org.openjdk.jmh.annotations.*;

import java.util.StringJoiner;
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
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS, batchSize = 1000)
@Measurement(iterations = 20, time = 1, timeUnit = TimeUnit.SECONDS, batchSize = 1000)
public class BuilderInLoop {

    private final char SLASH = '/';
    String uri = "/soMyUrlToService?param=123";
    int index = uri.indexOf('?');
    int ar[] = new int[] {1,2,3,4,5};

    @Benchmark
    public String builder() {
        int len = uri.length();
        StringBuilder sb = new StringBuilder(len + 1);
        sb.append(uri, 0, index)
                .append(SLASH)
                .append(uri, index, len);
        return sb.toString();
    }

    @Benchmark
    public String builderChained() {
        int len = uri.length();
        return new StringBuilder(len + 1)
                .append(uri, 0, index)
                .append(SLASH)
                .append(uri, index, len)
                .toString();
    }

    @Benchmark
    public String builderChained2() {
        int len = uri.length();
        StringBuilder sb = new StringBuilder(len + 1);
        return sb.append(uri, 0, index)
                .append(SLASH)
                .append(uri, index, len)
                .toString();
    }

}
