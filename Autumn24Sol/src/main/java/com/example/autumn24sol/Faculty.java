package com.example.autumn24sol;

public class Faculty extends User{
    private String subject;

    public Faculty(String name, int id, String dept, String email, String password, String subject) {
        super(name, id, dept, email, password);
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "subject='" + subject + '\'' +
                ", name='" + name + '\'' +
                ", id=" + id +
                ", dept='" + dept + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
