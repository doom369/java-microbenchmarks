package cc.microbenchmarks.core.chars;

import org.openjdk.jmh.annotations.*;

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
public class CharacterCompare {

    private char c = ' ';

    @Benchmark
    public boolean characterIsWhitespaceChar() {
        return Character.isWhitespace(c);
    }

    @Benchmark
    public boolean naiveCheckChar() {
        return c == ' ';
    }

}
