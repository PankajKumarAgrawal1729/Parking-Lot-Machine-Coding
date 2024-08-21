package services;

import model.ParkingLot;
import model.Slot;
import model.Ticket;
import model.Vehicle;

public class UnParkedvehicle {
    public void unParkedvehicle(ParkingLot parkingLot, String ticketId) {
        String[] ticketIdInfo = ticketId.split("_");
        int floorNumber = Integer.parseInt(ticketIdInfo[1]);
        int slotNumber = Integer.parseInt(ticketIdInfo[2]);
        boolean isValidFloorAndSlotNumber = parkingLot.isValidFloorNumber(floorNumber) && parkingLot.isValidSlotNumber(slotNumber);
        Slot slot = isValidFloorAndSlotNumber ? parkingLot.geSlotInfo(floorNumber - 1, slotNumber - 1) : null;
        if (slot != null) {
            Ticket ticketInfo = slot.getTicket();
            Vehicle vehicle = ticketInfo.getVehicle();
            String registrationNumber = vehicle.getRegistrationNumber();
            String color = vehicle.getColor();
            parkingLot.updateParkingLotFloor(null, floorNumber - 1,slotNumber - 1);
            System.out.println("Unparked vehicle with Registration Number: " + registrationNumber + " and Color: " + color);
        } else {
            System.out.println("Invalid Ticket");
        }
    }
}
