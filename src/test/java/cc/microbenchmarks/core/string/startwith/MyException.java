package cc.microbenchmarks.core.string.startwith;

/**
 * The Blynk Project.
 * Created by Dmitriy Dumanskiy.
 * Created on 22.04.17.
 */
public class MyException extends Exception {

    public MyException(String message) {
        super(message, null, true, false);
    }

    public MyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
