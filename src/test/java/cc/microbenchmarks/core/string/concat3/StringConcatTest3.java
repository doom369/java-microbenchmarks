package cc.microbenchmarks.core.string.concat3;

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
public class StringConcatTest3 {

    /*
    Benchmark                              Mode  Cnt      Score      Error  Units
StringConcatTest2.emptyStringInt      thrpt   20  45796.098 ± 1756.231  ops/s
StringConcatTest2.optimizedProbably   thrpt   20  28046.555 ± 1326.345  ops/s
StringConcatTest2.optimizedProbably2  thrpt   20  46795.328 ± 1856.543  ops/s
StringConcatTest2.simplest            thrpt   20  48742.056 ± 1467.460  ops/s
     */

    public static final char BODY_SEPARATOR = '\0';

    private String body1;
    private String body2;

    @Setup
    public void prepare() {
        body1 = "11111111111111111111";
        body2 = "22222222222222222222";
    }

    @Benchmark
    public String regularConcat() {
        return body1.trim() + BODY_SEPARATOR + body2.trim();
    }

    @Benchmark
    public String regulatSB() {
        return new StringBuilder()
                .append(body1.trim())
                .append(BODY_SEPARATOR)
                .append(body2.trim())
                .toString();
    }

    @Benchmark
    public String optimizeTrimmed() {
        final String trimmed1 = body1.trim();
        final String trimmed2 = body2.trim();
        return new StringBuilder(trimmed1.length() + 1 + trimmed2.length())
                .append(trimmed1)
                .append(BODY_SEPARATOR)
                .append(trimmed2)
                .toString();
    }

    @Benchmark
    public String optimizeTrimmedNoLength() {
        final String trimmed1 = body1.trim();
        final String trimmed2 = body2.trim();
        return new StringBuilder()
                .append(trimmed1)
                .append(BODY_SEPARATOR)
                .append(trimmed2)
                .toString();
    }

}
