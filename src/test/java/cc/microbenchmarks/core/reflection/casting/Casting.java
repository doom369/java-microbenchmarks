package cc.microbenchmarks.core.reflection.casting;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.BenchmarkParams;

/**
 * The Blynk Project.
 * Created by Dmitriy Dumanskiy.
 * Created on 13.12.16.
 */
@BenchmarkMode(Mode.Throughput)
@Fork(1)
@State(Scope.Thread)
@Warmup(iterations = 10, time = 1, batchSize = 1000)
@Measurement(iterations = 20, time = 1, batchSize = 1000)
public class Casting {

    public Object msg;

    public Class<String> type;

    @Setup
    public void setup(BenchmarkParams params) {
        type = String.class;
        msg = "123";
    }

    @Benchmark
    public boolean isInstanceMethod() {
        return type.isInstance(msg);
    }

    @Benchmark
    public boolean isInstanceMethodExplicit() {
        return String.class.isInstance(msg);
    }

    @Benchmark
    public boolean isInstanceRegular() {
        return msg instanceof String;
    }

    @Benchmark
    public String castMethod() {
        return type.cast(msg);
    }

    @Benchmark
    public String castMethodExplicit() {
        return String.class.cast(msg);
    }

    @Benchmark
    public String castRegular() {
        return (String) msg;
    }

}
