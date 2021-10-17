package com.json.model;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "user", namespace="users")
public class MyObject7 {

    public int id;
    public String name;

    public MyObject7(int id, String name) {
        this.id = id;
        this.name = name;
    }

}
