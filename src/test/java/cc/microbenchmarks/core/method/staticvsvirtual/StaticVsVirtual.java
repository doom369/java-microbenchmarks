package cc.microbenchmarks.core.method.staticvsvirtual;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.CompilerControl;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * The Blynk Project.
 * Created by Dmitriy Dumanskiy.
 * Created on 13.12.16.
 */
@Warmup(iterations = 10, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 10, time = 1, timeUnit = TimeUnit.SECONDS)
@Fork(5)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@State(Scope.Benchmark)
public class StaticVsVirtual {

    @Param("100000")
    private int count;

    private Data[] datas;

    @Setup
    public void setup() {
        Random r = new Random();

        datas = new Data[count];
        for (int c = 0; c < count; c++) {
            byte[] contents = new byte[10];
            r.nextBytes(contents);

            datas[c] = new Data((byte) 0, contents);
        }
    }

    @Benchmark
    public void static_Ref() {
        Data[] l = datas;
        int c = count;
        for (int i = 0; i < c; i++) {
            l[i].do_Static_Ref();
        }
    }

    @Benchmark
    public void dynamic_Interface_Ref() {
        Data[] l = datas;
        int c = count;
        for (int i = 0; i < c; i++) {
            l[i].do_Dynamic_Interface_Ref();
        }
    }

    @Benchmark
    public void dynamic_Abstract_Ref() {
        Data[] l = datas;
        int c = count;
        for (int i = 0; i < c; i++) {
            l[i].do_Dynamic_Abstract_Ref();
        }
    }

    @Benchmark
    public void dynamic_Abstract_Ref_private() {
        Data[] l = datas;
        int c = count;
        for (int i = 0; i < c; i++) {
            l[i].do_Dynamic_Abstract_Ref_Private();
        }
    }


    /**
     * The Blynk Project.
     * Created by Dmitriy Dumanskiy.
     * Created on 23.02.17.
     */
    public static class Coder0 extends AbstractCoder implements Coder {
        @Override
        public int work(byte[] data) {
            return data.length;
        }

        public static int staticWork(byte[] data) {
            return data.length;
        }

        @Override
        public int abstractWork(byte[] data) {
            return data.length;
        }

        private int abstractWorkPrivate(byte[] data) {
            return data.length;
        }

    }

    /**
     * The Blynk Project.
     * Created by Dmitriy Dumanskiy.
     * Created on 23.02.17.
     */
    public static class Data {

        private static final Coder0 coder0 = new Coder0();

        private final boolean isCoder0;
        private final byte id;
        private final byte[] data;
        private final Coder coder;
        private final AbstractCoder abstractCoder;

        public Data(byte id, byte[] data) {
            this.id = id;
            this.data = data;
            this.isCoder0 = (id == 0);
            this.coder = coder0;
            this.abstractCoder = coder0;
        }

        @CompilerControl(CompilerControl.Mode.DONT_INLINE)
        public int do_Static_Ref(){
            return Coder0.staticWork(data);
        }

        @CompilerControl(CompilerControl.Mode.DONT_INLINE)
        public int do_Dynamic_Interface_Ref(){
            return coder.work(data);
        }

        @CompilerControl(CompilerControl.Mode.DONT_INLINE)
        public int do_Dynamic_Abstract_Ref(){
            return abstractCoder.abstractWork(data);
        }

        @CompilerControl(CompilerControl.Mode.DONT_INLINE)
        public int do_Dynamic_Abstract_Ref_Private(){
            return coder0.abstractWorkPrivate(data);
        }
    }
}
