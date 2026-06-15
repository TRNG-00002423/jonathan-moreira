package com.vehicle;

public class ElectricCar extends Vehicle implements AutonomousCapable {
    private double kWhPer100Km, pricePerKWh;
    
    public ElectricCar(){}

    public ElectricCar(String make, int modelYear, double kWhPer100Km, double pricePerKWh) {
        super(make, modelYear);
        this.kWhPer100Km = kWhPer100Km;
        this.pricePerKWh = pricePerKWh;
    }

    public double getkWhPer100Km() {
        return kWhPer100Km;
    }

    public void setkWhPer100Km(double kWhPer100Km) {
        this.kWhPer100Km = kWhPer100Km;
    }

    public double getPricePerKWh() {
        return pricePerKWh;
    }

    public void setPricePerKWh(double pricePerKWh) {
        this.pricePerKWh = pricePerKWh;
    }

    @Override
    public double fuelCostPer100Km() {
        return kWhPer100Km * pricePerKWh;
    }

    @Override
    public boolean supportsSelfDrive() {
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ElectricCar{");
        sb.append("make=").append(this.getMake());
        sb.append(", modelYear=").append(this.getModelYear());
        sb.append(", kWhPer100Km=").append(kWhPer100Km);
        sb.append(", pricePerKWh=").append(pricePerKWh);
        
        sb.append('}');
        return sb.toString();
    }

   


}