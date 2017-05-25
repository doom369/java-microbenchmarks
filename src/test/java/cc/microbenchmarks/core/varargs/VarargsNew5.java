package cc.microbenchmarks.core.varargs;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.BenchmarkParams;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;

/**
 * The Blynk Project.
 * Created by Dmitriy Dumanskiy.
 * Created on 13.12.16.
 */
@BenchmarkMode(Mode.Throughput)
@Fork(1)
@State(Scope.Thread)
@Warmup(iterations = 10, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 20, time = 1, timeUnit = TimeUnit.SECONDS)
public class VarargsNew5 {

    String[] ar;
    String s1 = "1";
    String s2 = "2";
    String s3 = "3";


    @Setup
    public void setup() {
        ar = new String[] {s1, s2, s3};
    }

    @Benchmark
    public void varArgs() {
        varArgs(s1, s2, s3);
    }

    @Benchmark
    public void noVarArgs() {
        noVarArgs(s1, s2, s3);
    }

    //@CompilerControl(CompilerControl.Mode.EXCLUDE)
    public void varArgs(String... a) {

    }

    //@CompilerControl(CompilerControl.Mode.EXCLUDE)
    public void noVarArgs(String a1, String a2, String a3) {
    }


}
