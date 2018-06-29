package com.shoumipay.domain;

import java.io.Serializable;

public class Config implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String key;

    private String value;

    private String description;

    public Config(){}

    public Config(String key, String value, String description) {
        this.key = key;
        this.value = value;
        this.description = description;
    }

    public void update(Config config) {
        if (null != config.getId()) this.id = config.getId();
        if (null != config.getKey()) this.key = config.getKey();
        if (null != config.getValue()) this.value = config.getValue();
        if (null != config.getDescription()) this.description = config.getDescription();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key == null ? null : key.trim();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    @Override
    public String toString() {
        return "Config{" +
                "id=" + id +
                ", key='" + key + '\'' +
                ", value='" + value + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}