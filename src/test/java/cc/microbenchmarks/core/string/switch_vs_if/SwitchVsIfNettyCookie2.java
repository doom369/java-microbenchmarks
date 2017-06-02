package cc.microbenchmarks.core.string.switch_vs_if;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.Throughput)
@Fork(1)
@State(Scope.Thread)
@Warmup(iterations = 10, time = 1, timeUnit = TimeUnit.SECONDS, batchSize = 1000)
@Measurement(iterations = 20, time = 1, timeUnit = TimeUnit.SECONDS, batchSize = 1000)
public class SwitchVsIfNettyCookie2 {

    char c;

    @Setup
    public void init() {
        c = 'm';
    }

    @Benchmark
    public boolean testSwitch() throws Exception {
        switch (c) {
            case '\t':
            case '\n':
            case 0x0b:
            case '\f':
            case '\r':
            case ' ':
            case ',':
            case ';':
                return true;
        }
        return false;
    }

    @Benchmark
    public boolean testIf() throws Exception {
        return c == '\t' || c == '\n' || c == 0x0b || c == '\f'
                || c == '\r' || c == ' ' || c == ',' || c == ';';
    }

}