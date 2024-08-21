package model;

import enums.VEHICLETYPE;

public class Vehicle {
    VEHICLETYPE vehicletype;
    String registrationNumber;
    String color;

    public Vehicle(VEHICLETYPE vehicletype, String registrationNumber, String color) {
        this.vehicletype = vehicletype;
        this.registrationNumber = registrationNumber;
        this.color = color;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getColor() {
        return color;
    }
}
