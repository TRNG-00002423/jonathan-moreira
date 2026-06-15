package com.vehicle;

import java.util.ArrayList;
import java.util.List;

public class VehicleDemo {
    public static void main(String[] args) {
        List<Vehicle> fleet = new ArrayList<>();
        // TODO: add GasCar, ElectricCar, optionally one that implements AutonomousCapable
        // TODO: polymorphic loop + instanceof demo
        fleet.add(new GasCar("Nissan", 2015, 20.0, 4.0));
        fleet.add(new ElectricCar("Tesla", 2020, 15.0, 6.0));

        for(Vehicle vehicle : fleet){
            System.out.println(vehicle);
            System.out.printf("Fuel cost per 100km: %.2f\n",vehicle.fuelCostPer100Km());
            if(vehicle instanceof  ElectricCar electricCar){
                System.out.println("Vehicle: " + vehicle.getMake() + " is an instance of: "+ vehicle.getClass());
                System.out.println("Vehicle supports selfdrive: " + electricCar.supportsSelfDrive());
            }
            
        }
    }
}