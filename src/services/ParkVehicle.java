package services;

import enums.VEHICLETYPE;
import model.Slot;
import model.Ticket;

public class ParkVehicle {
    public Slot vehicleParked(String parkingLotId, int floorNumber, int slotNumber, VEHICLETYPE vehicletype,
            String registrationNumber, String color) {
        Ticket vehicleTicket = Ticket.generateTicket(parkingLotId, floorNumber, slotNumber,
                vehicletype, registrationNumber, color);
        String ticketId = vehicleTicket.getTicketId();

        System.out.println("Parked vehicle. Ticket ID: " + ticketId);
        return new Slot(ticketId, vehicleTicket);
    }
}
