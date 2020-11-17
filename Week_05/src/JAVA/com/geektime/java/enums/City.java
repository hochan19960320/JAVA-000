package com.geektime.java.enums;

public enum City {

    SHUNDE(1,"美食"),
    GUANGZHOU(2,"人很多");

    private Integer id;
    private String name;

    City(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
