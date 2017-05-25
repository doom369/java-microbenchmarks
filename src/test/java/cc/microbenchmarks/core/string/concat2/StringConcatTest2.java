package cc.microbenchmarks.core.string.concat2;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
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
@Measurement(iterations = 20, time = 1, timeUnit = TimeUnit.SECONDS, batchSize = 1000)
public class StringConcatTest2 {

    /*
    Benchmark                              Mode  Cnt      Score      Error  Units
StringConcatTest2.emptyStringInt      thrpt   20  45796.098 ± 1756.231  ops/s
StringConcatTest2.optimizedProbably   thrpt   20  28046.555 ± 1326.345  ops/s
StringConcatTest2.optimizedProbably2  thrpt   20  46795.328 ± 1856.543  ops/s
StringConcatTest2.simplest            thrpt   20  48742.056 ± 1467.460  ops/s
     */

    public static final char BODY_SEPARATOR = '\0';

    private int aInt;
    private String body;

    @Setup
    public void prepare() {
        aInt = 100;
        body = "123 123 123 123 123 123";
    }

    @Benchmark
    public String regularConcat() {
        return regularConcat(aInt, body);
    }

    @Benchmark
    public String optimizedProbably() {
        return makeOldBody(aInt, body);
    }

    @Benchmark
    public String optimizedProbably2() {
        return makeOldBody2(aInt, body);
    }

    private static String regularConcat(int dashId, String body) {
        return String.valueOf(dashId) + BODY_SEPARATOR + body;
    }

    private static String makeOldBody(int dashId, String body) {
        final String dashIdString = String.valueOf(dashId);
        return new StringBuilder()
                .append(dashIdString)
                .append(BODY_SEPARATOR)
                .append(body)
                .toString();
    }


    private static String makeOldBody2(int dashId, String body) {
        return new StringBuilder()
                .append(dashId)
                .append(BODY_SEPARATOR)
                .append(body)
                .toString();
    }


}
