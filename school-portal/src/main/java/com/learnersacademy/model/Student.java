package com.learnersacademy.model;

import javax.persistence.Entity;

@Entity
public class Student {
    private long id;
    private String name;
    private int classId;

    // Constructor, getters, setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    // Override toString() for debugging purposes
    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "', classId=" + classId + "}";
    }
}

