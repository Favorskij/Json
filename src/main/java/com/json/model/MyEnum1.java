package com.json.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum MyEnum1 {

    TYPE1(1, "Type A"), TYPE2(2, "Type 2");

    private final Integer id;
    private final String name;

    MyEnum1(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @JsonValue
    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }
}
