package com.example.autumn24sol;

public class Student extends User{
    private float cgpa;

    public Student(String name, int id, String dept, String email, String password, float cgpa) {
        super(name, id, dept, email, password);
        this.cgpa = cgpa;
    }

    public float getCgpa() {
        return cgpa;
    }

    public void setCgpa(float cgpa) {
        this.cgpa = cgpa;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", dept='" + dept + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                "cgpa=" + cgpa +
                '}';
    }
}
















