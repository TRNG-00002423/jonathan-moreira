package com.vehicle;

public abstract class Vehicle {
    private String make;
    private int modelYear;

    public Vehicle() {}
    public Vehicle(String make, int modelYear) {
        this.make = make;
        this.modelYear = modelYear;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public int getModelYear() {
        return modelYear;
    }

    public void setModelYear(int modelYear) {
        this.modelYear = modelYear;
    }

    public abstract double fuelCostPer100Km();

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Vehicle{");
        sb.append("make=").append(make);
        sb.append(", modelYear=").append(modelYear);
        sb.append('}');
        return sb.toString();
    }


}