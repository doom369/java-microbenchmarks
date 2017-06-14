package cc.microbenchmarks.core.string.stringbuilder_insert;

import org.openjdk.jmh.annotations.*;

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
public class BuilderInsertCharConcat {

    private static final char SLASH = '/';
    private static final char QUESTION_MARK = '?';

    private String uri = "http://localhost?eventType=CRITICAL&from=0&to=1497437160327&limit=10&offset=0";

    public static void main(String[] args) {
        String uri = "http://localhost?eventType=CRITICAL&from=0&to=1497437160327&limit=10&offset=0";
        int start = uri.indexOf("://");
        int index = uri.indexOf(QUESTION_MARK, start + 3);
        int len = uri.length();
        String s = uri.substring(0, index) + SLASH + uri.substring(index, len);

        System.out.println(s);
    }

    @Benchmark
    public String original() {
        int start = uri.indexOf("://");
        int index = uri.indexOf(QUESTION_MARK, start + 3);
        int len = uri.length();
        StringBuilder sb = new StringBuilder(len + 1);
        sb.append(uri, 0, index)
                .append(SLASH)
                .append(uri, index, len);
        return sb.toString();
    }

    @Benchmark
    public String improved() {
        int start = uri.indexOf("://");
        int index = uri.indexOf(QUESTION_MARK, start + 3);
        int len = uri.length();
        return new StringBuilder(len + 1)
                .append(uri, 0, index)
                .append(SLASH)
                .append(uri, index, len)
                .toString();
    }

    @Benchmark
    public String insert() {
        int start = uri.indexOf("://");
        int index = uri.indexOf(QUESTION_MARK, start + 3);

        return new StringBuilder(uri)
                .insert(index, SLASH)
                .toString();
    }

    @Benchmark
    public String concat() {
        int start = uri.indexOf("://");
        int index = uri.indexOf(QUESTION_MARK, start + 3);
        int len = uri.length();
        return uri.substring(0, index) + SLASH + uri.substring(index, len);
    }
}
