package model;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private static ParkingLot parkingLot = null;

    public static ParkingLot getParkingLot(String parkingLotId, int numberOfFloor, int numberOfSlots) {
        if (parkingLot != null) {
            return parkingLot;
        }
        return new ParkingLot(parkingLotId, numberOfFloor, numberOfSlots);
    }

    String parkingLotId;
    int numberOfFloor;
    int numberOfSlots;

    List<Floor> parkingLotFloors;

    private ParkingLot(String parkingLotId, int numberOfFloor, int numberOfSlots) {
        this.parkingLotId = parkingLotId;
        this.numberOfFloor = numberOfFloor;
        this.numberOfSlots = numberOfSlots;
        this.parkingLotFloors = new ArrayList<>();
    }

    public void createParkingLot() {
        for (int i = 0; i < numberOfFloor; i++) {
            parkingLotFloors.add(new Floor(numberOfSlots));
        }
        System.out.println("Created parking lot with " + this.numberOfFloor + " floors and " + this.numberOfSlots
                + " slots per floor");
    }

    public String getParkingLotId() {
        return parkingLotId;
    }

    public int getNumberOfFloor() {
        return numberOfFloor;
    }

    public int getNumberOfSlots() {
        return numberOfSlots;
    }

    public List<Floor> getParkingLotFloors() {
        return parkingLotFloors;
    }

    public void updateParkingLotFloor(Slot bookedSlot, int floorNumber, int slotNumber){
        this.parkingLotFloors.get(floorNumber).getSlots()[slotNumber] = bookedSlot;
    }

    public Slot geSlotInfo(int floorNumber, int slotNumber){
        return this.parkingLotFloors.get(floorNumber).getSlots()[slotNumber];
    }

    public boolean isValidFloorNumber(int floorNumber){
        return 0 <= floorNumber && floorNumber <= numberOfFloor;
    }

    public boolean isValidSlotNumber(int slotNumber){
        return 0 <= slotNumber && slotNumber <= numberOfSlots;
    }
}
