package com.vehicle;

public class GasCar extends Vehicle {
    private double litersPer100Km, pricePerLiter;

    public GasCar() {
    }

    public GasCar( String make, int modelYear, double litersPer100Km, double pricePerLiter) {
        super(make, modelYear);
        this.litersPer100Km = litersPer100Km;
        this.pricePerLiter = pricePerLiter;
    }

    public double getLitersPer100Km() {
        return litersPer100Km;
    }

    public void setLitersPer100Km(double litersPer100Km) {
        this.litersPer100Km = litersPer100Km;
    }

    public double getPricePerLiter() {
        return pricePerLiter;
    }

    public void setPricePerLiter(double pricePerLiter) {
        this.pricePerLiter = pricePerLiter;
    }

    @Override
    public double fuelCostPer100Km() {
        return litersPer100Km * pricePerLiter;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("GasCar{");
        sb.append("make=").append(this.getMake());
        sb.append(", modelYear=").append(this.getModelYear());
        sb.append(", litersPer100Km=").append(litersPer100Km);
        sb.append(", pricePerLiter=").append(pricePerLiter);
        sb.append('}');
        return sb.toString();
    }

}