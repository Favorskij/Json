package com.json.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class MyObject11 {

    public int id;
    private String name;

    @JsonSetter("name") // Имя будет вставлено именно в этот метод (setTheName), а не в метод setName.
    // Тоже-самое и JsonGetter, только на оборот, получение.
    public void setTheName(String name) {
        this.name = name;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
