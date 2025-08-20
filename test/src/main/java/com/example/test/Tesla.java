package com.example.test;

public class Tesla extends Car implements Vehicle{
    @Override
    void drive(){
        System.out.println("driving the car Tesla");
    }

    @Override
    public void start(){
        System.out.println("Start Tesla");
    }

    @Override
    public void stop() {
        System.out.println("Stop Tesla");
    }
}
