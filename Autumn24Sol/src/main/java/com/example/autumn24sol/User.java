package com.example.autumn24sol;

public class User {
    protected String name;
    protected int id;
    protected String dept;
    protected String email;
    protected String password;

    public User(String name, int id, String dept, String email, String password) {
        this.name = name;
        this.id = id;
        this.dept = dept;
        this.email = email;
        this.password = password;
    }

    public void login(int id, String pass){
        System.out.println("Logged in");
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", dept='" + dept + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
