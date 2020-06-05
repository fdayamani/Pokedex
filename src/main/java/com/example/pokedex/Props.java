package com.example.pokedex;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app")
public class Props {
    private String scheme;
    private String host;
    private String port;

    public String getScheme() {
        return scheme;
    }

    public String getHost() {
        return host;
    }

    public String getPort() {
        return port;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setPort(String port) {
        this.port = port;
    }
}
