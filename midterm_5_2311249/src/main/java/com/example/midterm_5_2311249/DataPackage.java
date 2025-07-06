package com.example.midterm_5_2311249;

public class DataPackage {
    private String packageName;
    private double dataAmount;
    private String validity;
    private double price;
    private String availability;
    private int offerEnds;

    public DataPackage(String packageName, double dataAmount, String validity, double price, String availability, int offerEnds) {
        this.packageName = packageName;
        this.dataAmount = dataAmount;
        this.validity = validity;
        this.price = price;
        this.availability = availability;
        this.offerEnds = offerEnds;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public double getDataAmount() {
        return dataAmount;
    }

    public void setDataAmount(double dataAmount) {
        this.dataAmount = dataAmount;
    }

    public String getValidity() {
        return validity;
    }

    public void setValidity(String validity) {
        this.validity = validity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public int getOfferEnds() {
        return offerEnds;
    }

    public void setOfferEnds(int offerEnds) {
        this.offerEnds = offerEnds;
    }

    @Override
    public String toString() {
        return "DataPackage{" +
                "packageName='" + packageName + '\'' +
                ", dataAmount=" + dataAmount +
                ", validity='" + validity + '\'' +
                ", price=" + price +
                ", availability='" + availability + '\'' +
                ", offerEnds=" + offerEnds +
                '}';
    }
}
