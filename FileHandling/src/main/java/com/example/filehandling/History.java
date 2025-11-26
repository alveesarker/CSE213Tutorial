package com.example.filehandling;

import java.io.Serializable;

public class History implements Serializable {
    private int num1;
    private int getNum1;
    private int result;

    public History(int num1, int getNum1, int result) {
        this.num1 = num1;
        this.getNum1 = getNum1;
        this.result = result;
    }

    public History(int num1, int getNum1){
        this.num1 = num1;
        this.getNum1 = getNum1;
        this.result = num1 + getNum1;
    }

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getGetNum1() {
        return getNum1;
    }

    public void setGetNum1(int getNum1) {
        this.getNum1 = getNum1;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "History{" +
                "num1=" + num1 +
                ", getNum1=" + getNum1 +
                ", result=" + result +
                '}';
    }
}
