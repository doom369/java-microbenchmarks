package cc.microbenchmarks.core.collections.iteration2;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

/**
 * The Blynk Project.
 * Created by Dmitriy Dumanskiy.
 * Created on 12.02.17.
 */
@BenchmarkMode(Mode.Throughput)
@Fork(1)
@State(Scope.Thread)
@Warmup(iterations = 10, time = 1, timeUnit = TimeUnit.SECONDS, batchSize = 1000)
@Measurement(iterations = 20, time = 1, timeUnit = TimeUnit.SECONDS, batchSize = 1000)
public class IterationWithConstant {

    MyList1<Integer> myList1;
    MyList2<Integer> myList2;

    @Setup
    public void init() {
        myList1 = new MyList1<>();
        myList1.add(100500);

        myList2 = new MyList2<>();
        myList2.add(100500);
    }

    @Benchmark
    public Integer iterateListViaIndex() {
        int r = 0;
        for (int i = 0; i < myList1.size(); i++) {
            r += myList1.get(i);
        }
        return r ;
    }

    @Benchmark
    public Integer iterateListViaIndexVar() {
        int r = 0;
        final int size = myList1.size();
        for (int i = 0; i < size; i++) {
            r += myList1.get(i);
        }
        return r;
    }

    @Benchmark
    public Integer iterateListViaIndex2() {
        int r = 0;
        for (int i = 0; i < myList2.size(); i++) {
            r += myList2.get(i);
        }
        return r;
    }

    @Benchmark
    public Integer iterateListViaIndexVar2() {
        int r = 0;
        final int size = myList2.size();
        for (int i = 0; i < size; i++) {
            r += myList2.get(i);
        }
        return r;
    }

    private class MyList1<E> extends ArrayList<E> {
        @Override
        public int size() {
            return super.size();
        }
    }

    private class MyList2<E> extends ArrayList<E> {
        int i;
        @Override
        public int size() {
            i++;
            return super.size();
        }
    }

}
