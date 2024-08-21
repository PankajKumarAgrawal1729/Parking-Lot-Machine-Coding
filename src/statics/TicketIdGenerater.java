package statics;

public class TicketIdGenerater {
    public String generateVehicleTicketId(String parkingLotId, int floorNumber, int slotNumber) {
        String ticket = parkingLotId + "_" + Integer.toString(floorNumber) + "_" + Integer.toString(slotNumber);
        return ticket;
    }
}
