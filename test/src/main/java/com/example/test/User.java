package com.example.test;

abstract public class User {
    protected int id;
    protected String name;
    protected String email;
    protected String gender;

    public User(int id, String name, String email, String gender) {
    }


    abstract public void login();
;
}
