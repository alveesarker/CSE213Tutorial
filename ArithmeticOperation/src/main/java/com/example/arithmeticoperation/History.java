package com.example.arithmeticoperation;

public class History {
    private int numOne;
    private int numTwo;
    private int result;

    public History(int numOne, int numTwo, int result) {
        this.numOne = numOne;
        this.numTwo = numTwo;
        this.result = result;
    }

    public int getNumOne() {
        return numOne;
    }

    public void setNumOne(int numOne) {
        this.numOne = numOne;
    }

    public int getNumTwo() {
        return numTwo;
    }

    public void setNumTwo(int numTwo) {
        this.numTwo = numTwo;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
