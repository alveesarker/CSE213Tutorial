package com.cse.oop.final_section1_1234567;

import java.io.Serializable;

public class Monitor implements Serializable {
    private String model;
    private String resolution;
    private int diagonal;
    private float price;
    private int ppi;

    public Monitor(String model, String resolution, int diagonal, float price) {
        this.model = model;
        this.resolution = resolution;
        this.diagonal = diagonal;
        this.price = price;
        this.ppi = this.getPPI();
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public int getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(int diagonal) {
        this.diagonal = diagonal;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getPpi() {
        return ppi;
    }

    public void setPpi(int ppi) {
        this.ppi = ppi;
    }

    public int getPPI(){
        if (this.resolution.equals("HD")){
            if(this.diagonal == 17){
                return 86;
            } else if (this.diagonal == 19) {
                return 77;
            } else if (this.diagonal == 22) {
                return 67;
            } else if(this.diagonal == 24){
                return 61;
            }
        } else {
            return 90;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Monitor{" +
                "model='" + model + '\'' +
                ", resolution='" + resolution + '\'' +
                ", diagonal=" + diagonal +
                ", price=" + price +
                ", ppi=" + ppi +
                '}';
    }
}
