package cc.microbenchmarks.core.chaining;

import org.openjdk.jmh.annotations.*;

/**
 * The Blynk Project.
 * Created by Dmitriy Dumanskiy.
 * Created on 04.06.17.
 */
@BenchmarkMode(Mode.Throughput)
@Fork(1)
@State(Scope.Thread)
@Warmup(iterations = 10, time = 1, batchSize = 1000)
@Measurement(iterations = 10, time = 1, batchSize = 1000)
public class UriBuilderChaining {

    private String host = "host";
    private String schema = "http";
    private String path = "/123/123/123";

    @Benchmark
    public String chaining() {
        return new UriBuilder().setSchema(schema).setHost(host).setPath(path).toString();
    }

    @Benchmark
    public String noChaining() {
        UriBuilder uriBuilder = new UriBuilder();
        uriBuilder.setSchema(schema);
        uriBuilder.setHost(host);
        uriBuilder.setPath(path);
        return uriBuilder.toString();
    }

}
