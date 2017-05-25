package cc.microbenchmarks.core.reflection;

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

import java.util.concurrent.TimeUnit;

/**
 * The Blynk Project.
 * Created by Dmitriy Dumanskiy.
 * Created on 13.12.16.
 */
@BenchmarkMode(Mode.SingleShotTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Fork(1)
@State(Scope.Thread)
@Warmup(iterations = 5, batchSize = 10_000, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, batchSize = 10_000, timeUnit = TimeUnit.SECONDS)
public class ReflectionSingleIsInstance {

    public Widget[] widgets;
    public Widget widget;
    public Widget notif;

    @Setup
    public void setup(BenchmarkParams params) {
        widget = new Widget();
        notif = new Notification();
    }

    @Benchmark
    public boolean reflection1() {
        return widget instanceof Notification;
    }

    @Benchmark
    public boolean regularJava1() {
        return Notification.class.isInstance(widget);
    }


    private class Notification extends Widget {

    }

    private class Widget {

    }


}
