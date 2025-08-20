package com.example.test;

public class DataPackage {
    private Float price;
    private Float disPrice;

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getDisPrice() {
        return disPrice;
    }

    public void setDisPrice(Float disPrice) {
        this.disPrice = disPrice;
    }

    public DataPackage(Float price) {
        this.price = price;
    }

    public void setDiscountPrice(){
        if (this.price >= 1000){
            this.disPrice = 10f;
        } else if (this.price >= 500) {
            this.disPrice = 5f;
        }
    }
}
