package com.json.model;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "user")
public class MyObject6 {

    public int id;
    public String name;

    public MyObject6(int id, String name) {
        this.id = id;
        this.name = name;
    }

}
