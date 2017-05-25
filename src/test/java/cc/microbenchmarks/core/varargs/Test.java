package cc.microbenchmarks.core.varargs;

/**
 * The Blynk Project.
 * Created by Dmitriy Dumanskiy.
 * Created on 22.04.17.
 */
public class Test {

    public void make(String... a) {

    }

    public void noMake(String a1, String a2) {

    }

    public static void main(String... args) {
        Test a = new Test();
        a.make("1", "2");
        a.noMake("1", "2");
    }

}
