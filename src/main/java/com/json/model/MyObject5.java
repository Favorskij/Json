package com.json.model;

import com.fasterxml.jackson.annotation.JsonRawValue;

public class MyObject5 {

    public String name;

    @JsonRawValue
    public String json;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }
}
