package com.example.starter;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "example.hello")
public class HelloProperties {

    private String perfix;
    private String suffix;

    public String getPerfix() {
        return perfix;
    }

    public void setPerfix(String perfix) {
        this.perfix = perfix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}
