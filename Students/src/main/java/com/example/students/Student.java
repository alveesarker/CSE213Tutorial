package com.example.students;

import java.util.ArrayList;

public class Student {
    private String name;
    private int id;
    private float cgpa;
    private String dept;

    public Student(String name, int id, float cgpa, String dept) {
        this.name = name;
        this.id = id;
        this.cgpa = cgpa;
        this.dept = dept;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getCgpa() {
        return cgpa;
    }

    public void setCgpa(float cgpa) {
        this.cgpa = cgpa;
    }


    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", cgpa=" + cgpa +
                ", dept='" + dept + '\'' +
                '}';
    }
}
