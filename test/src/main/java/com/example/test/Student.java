package com.example.test;

public class Student extends User{
    private String dept;
    private String cgpa;

    public Student(int id, String name, String email, String gender, String dept, String cgpa) {
        super(id, name, email, gender);
        this.dept = dept;
        this.cgpa = cgpa;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getCgpa() {
        return cgpa;
    }

    public void setCgpa(String cgpa) {
        if (Integer.parseInt(cgpa) > 4 || Integer.parseInt(cgpa) < 0){
            return;
        }
        this.cgpa = cgpa;
    }

    @Override
    public void login(){
        System.out.println("lksdf");
    }


    @Override
    public String toString() {
        return "Student{" +
                "dept='" + dept + '\'' +
                ", cgpa='" + cgpa + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
