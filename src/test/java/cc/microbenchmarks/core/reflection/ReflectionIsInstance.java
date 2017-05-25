package cc.microbenchmarks.core.reflection;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.BenchmarkParams;

import javax.management.Notification;
import java.lang.reflect.Field;
import java.util.concurrent.TimeUnit;

/**
 * The Blynk Project.
 * Created by Dmitriy Dumanskiy.
 * Created on 13.12.16.
 */
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Fork(1)
@State(Scope.Thread)
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
public class ReflectionIsInstance {

    public Widget[] widgets;
    public Widget widget;
    public Widget notif;

    @Setup
    public void setup(BenchmarkParams params) {
        widget = new Widget();
        notif = new Notification();

        widgets = new Widget[] {
                new Widget(),
                new Widget(),
                new Widget(),
                new Widget(),
                new Widget(),
                new Widget(),
                new Widget(),
                new Notification(),
                new Widget()
        };
    }

    @Benchmark
    public Object reflection1() {
        return getWidgetByType(widget, Notification.class);
    }

    @Benchmark
    public Object reflection2() {
        return getWidgetByType(notif, Notification.class);
    }

    @Benchmark
    public Object regularJava1() {
        return getWidgetByType(widget);
    }

    @Benchmark
    public Object regularJava2() {
        return getWidgetByType(notif);
    }


    public  <T> T getWidgetByType(Widget widget, Class<T> clazz) {
        if (clazz.isInstance(widget)) {
            return clazz.cast(widget);
        }
        return null;
    }

    public Notification getWidgetByType(Widget widget) {
        if (widget instanceof Notification) {
            return (Notification) widget;
        }
        return null;
    }

    private class Notification extends Widget {

    }

    private class Widget {

    }


}
