package com.json.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Date;

public class MyObject8 {

    public String name;

    @JsonSerialize(using = CustomDateSerializer.class)
    public Date eventDate;

    public MyObject8(String name, Date eventDate) {
        this.name = name;
        this.eventDate = eventDate;
    }

}
