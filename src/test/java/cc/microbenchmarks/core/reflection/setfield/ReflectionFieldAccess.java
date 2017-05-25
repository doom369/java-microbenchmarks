package cc.microbenchmarks.core.reflection.setfield;

import com.sun.deploy.util.ReflectionUtil;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.BenchmarkParams;

import java.lang.reflect.Field;
import java.util.concurrent.TimeUnit;

/**
 * The Blynk Project.
 * Created by Dmitriy Dumanskiy.
 * Created on 13.12.16.
 */
@BenchmarkMode(Mode.Throughput)
@Fork(1)
@State(Scope.Thread)
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS, batchSize = 1000)
@Measurement(iterations = 20, time = 1, timeUnit = TimeUnit.SECONDS, batchSize = 1000)
public class ReflectionFieldAccess {

    private User user;
    private String fieldName;
    private Field cachedField;
    private String value = "My value";

    @Setup
    public void setup(BenchmarkParams params) throws Exception {
        user = new User();
        fieldName = "name";
        cachedField = User.class.getDeclaredField(fieldName);
    }

    @Benchmark
    public void reflection() throws Exception {
        User.class.getDeclaredField(fieldName).set(user, value);
    }

    @Benchmark
    public void reflectionCachedField() throws Exception {
        cachedField.set(user, value);
    }

    @Benchmark
    public void regularJava() {
        String value = "My value";
        switch (fieldName) {
            case "name" :
                user.name = value;
                break;
            case "color" :
                user.color = value;
                break;
            case "label" :
                user.label = value;
                break;
        }
    }


    private class User {
        String name;
        String color;
        String label;
    }

}
