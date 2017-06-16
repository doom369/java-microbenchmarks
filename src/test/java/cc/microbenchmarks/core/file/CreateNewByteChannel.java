package cc.microbenchmarks.core.file;

import org.openjdk.jmh.annotations.*;

import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static java.nio.file.StandardOpenOption.READ;

/**
 * The Blynk Project.
 * Created by Dmitriy Dumanskiy.
 * Created on 13.12.16.
 */
@BenchmarkMode(Mode.Throughput)
@Fork(1)
@State(Scope.Thread)
@Warmup(iterations = 10, time = 1, timeUnit = TimeUnit.SECONDS, batchSize = 1000)
@Measurement(iterations = 10, time = 1, timeUnit = TimeUnit.SECONDS, batchSize = 1000)
public class CreateNewByteChannel {

    public Path path = Paths.get("/tmp");

    public static String newByteChannel(Path path, OpenOption... options)
    {
        Set<OpenOption> set = new HashSet<>(options.length);
        Collections.addAll(set, options);
        return newByteChannel(path, set);
    }

    public static String newByteChannel(Path path,
                                                     Set<? extends OpenOption> options,
                                                     FileAttribute<?>... attrs)
    {
        return doNothing(path, options, attrs);
    }

    public static String doNothing(Path path,
                                 Set<? extends OpenOption> options,
                                 FileAttribute<?>... attrs) {
         return "123";
    }

    @Benchmark
    public String regular() {
        return newByteChannel(path, READ);
    }

    @Benchmark
    public String narrowed() {
        return newByteChannel(path, EnumSet.of(READ));
    }

    @Benchmark
    public String doNothing() {
        return doNothing(null, null, null);
    }

}
