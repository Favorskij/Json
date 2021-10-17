package com.json.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;

import java.util.Map;

public class MyObject3 {

    public String name;

    private Map<String, String> properties;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonAnyGetter
    public Map<String, String> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, String> properties) {
        this.properties = properties;
    }

}
