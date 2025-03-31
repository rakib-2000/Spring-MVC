package com.rakx07.model;

public class Student {

    private Integer id;
    private String name;
    private String batch;
    private Integer mark;

    public Student() {
    }

    public Student(Integer id, String name, String batch, Integer mark) {
        this.id = id;
        this.name = name;
        this.batch = batch;
        this.mark = mark;
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

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }
}
