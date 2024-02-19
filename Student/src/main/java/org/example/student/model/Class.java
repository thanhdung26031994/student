package org.example.student.model;

public class Class {
    private Integer id;
    private String name;

    public Class(Integer id) {
        this.id = id;
    }

    public Class(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
