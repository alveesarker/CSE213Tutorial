package com.example.autumn24sol;

public class Main {
    public static void main(String[] args){
//        Employee em = new Employee(123, "abc@example.com", 2000);
        Student s = new Student("a", 123, "cse", "a@gmail.com", "askfl", 2.3f);
        System.out.println(s.toString());
        s.login(123, "askfl");
    }
}
