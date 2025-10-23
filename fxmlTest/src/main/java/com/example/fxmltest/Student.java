package com.example.fxmltest;

public class Student {
    private int id;
    private String dept;


    public Student(int id, String dept) {
        this.id = id;
        this.dept = dept;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }
}
