package cc.microbenchmarks.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
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
@Warmup(iterations = 10, time = 1, timeUnit = TimeUnit.SECONDS, batchSize = 1000)
@Measurement(iterations = 20, time = 1, timeUnit = TimeUnit.SECONDS, batchSize = 1000)
public class ManualJson {

    User user;
    ObjectWriter writer = new ObjectMapper().writerFor(User.class);
    ObjectMapper objectMapper = new ObjectMapper();

    @Setup
    public void setup() {
        user = new User("My Name", 33);
    }

    @Benchmark
    public String jsonSerializeMapper() throws Exception {
        return objectMapper.writeValueAsString(user);
    }

    @Benchmark
    public String jsonSerializeWriter() throws Exception {
        return writer.writeValueAsString(user);
    }

    @Benchmark
    public String manualSerialize() {
        return "{\"name\":\"" + user.name + "\",\"age\":" + user.age + "}";
    }

    @Benchmark
    public String manualSerializePre() {
        final String name = user.name;
        final int age = user.age;
        return "{\"name\":\"" + name + "\",\"age\":" + age + "}";
    }

}
