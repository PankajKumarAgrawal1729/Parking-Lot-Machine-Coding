package model;

import enums.VEHICLETYPE;
import statics.TicketIdGenerater;

public class Ticket {
    String ticketId;
    Vehicle vehicle;
    TicketIdGenerater ticketIdGenerater = new TicketIdGenerater();

    public Ticket(String parkingLotId, int floorNumber, int slotNumber, Vehicle vehicle) {
        this.ticketId = ticketIdGenerater.generateVehicleTicketId(parkingLotId, floorNumber + 1, slotNumber + 1);
        this.vehicle = vehicle;
    }

    public static Ticket generateTicket(String parkingLotId, int floorNumber, int slotNumber, VEHICLETYPE vehicletype,
            String registrationNumber, String color) {

        return new Ticket(parkingLotId, floorNumber, slotNumber, new Vehicle(vehicletype, registrationNumber, color));
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public String getTicketId() {
        return ticketId;
    }
}
