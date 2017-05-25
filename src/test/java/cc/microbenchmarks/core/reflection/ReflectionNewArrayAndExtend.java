package cc.microbenchmarks.core.reflection;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OperationsPerInvocation;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.BenchmarkParams;

import java.lang.reflect.Array;
import java.util.concurrent.TimeUnit;

/**
 * The Blynk Project.
 * Created by Dmitriy Dumanskiy.
 * Created on 13.12.16.
 */
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Fork(1)
@State(Scope.Thread)
public class ReflectionNewArrayAndExtend {

    //@Param({"0", "1", "5", "10", "100"})
    //int size;

    Widget widget;
    Widget[] array;

    @Setup
    public void setup(BenchmarkParams params) {
        widget = new Widget();
        array = new Widget[0];
    }

    @Benchmark
    @Warmup(iterations = 10, batchSize = 10_000_000)
    @Measurement(iterations = 50, batchSize = 10_000_000)
    @BenchmarkMode(Mode.SingleShotTime)
    public Object reflection() {
        return addReflection(array, widget, Widget.class);
    }

    @Benchmark
    @Warmup(iterations = 10, batchSize = 10_000_000)
    @Measurement(iterations = 50, batchSize = 10_000_000)
    @BenchmarkMode(Mode.SingleShotTime)
    public Object regularJava() {
        return add(array, widget);
    }

    private static Widget[] add(Widget[] array, Widget element) {
        Widget[] newArray = copyArrayGrow1(array);
        newArray[newArray.length - 1] = element;
        return newArray;
    }
    private static Widget[] copyArrayGrow1(final Widget[] array) {
        Widget[] newArray = new Widget[array.length + 1];
        System.arraycopy(array, 0, newArray, 0, array.length);
        return newArray;
    }



    private static <T> T[] addReflection(T[] array, T element, Class<T> type) {
        T[] newArray = copyArrayGrow1Reflection(array, type);
        newArray[newArray.length - 1] = element;
        return newArray;
    }
    private static <T> T[] copyArrayGrow1Reflection(final T[] array, Class<T> type) {
        T[] newArray = (T[]) Array.newInstance(type, array.length + 1);
        System.arraycopy(array, 0, newArray, 0, array.length);
        return newArray;
    }

    private class Widget {

    }


}
