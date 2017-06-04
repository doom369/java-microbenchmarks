package cc.microbenchmarks.core.chaining;

/**
 * The Blynk Project.
 * Created by Dmitriy Dumanskiy.
 * Created on 04.06.17.
 */
public class UriBuilder {

    private String schema;

    private String host;

    private int port;

    private String path;

    public UriBuilder() {

    }

    public UriBuilder setSchema(String schema) {
        this.schema = schema;
        return this;
    }

    public UriBuilder setHost(String host) {
        this.host = host;
        return this;
    }

    public UriBuilder setPort(int port) {
        this.port = port;
        return this;
    }

    public UriBuilder setPath(String path) {
        this.path = path;
        return this;
    }

    @Override
    public String toString() {
        return schema + "://" + host + ":" + port + path;
    }
}
