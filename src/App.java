import java.util.Scanner;

import enums.COMMANDS;
import enums.DISPLAYTYPE;
import enums.VEHICLETYPE;
import model.ParkingLot;
import model.Slot;
import services.FreeSlot;
import services.FreeSlotAvailabilityInfo;
import services.FreeSlotsCount;
import services.FreeSlotsInfo;
import services.OccupiedSlotsInfo;
import services.ParkVehicle;
import services.UnParkedvehicle;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Parking Lot Id");
        String parkingLotId = sc.nextLine();

        System.out.println("Enter Number of Floor in Parking Lot");
        int numberOfFloor = sc.nextInt();

        System.out.println("Enter Number of Slots per Floor in Parking Lot");
        int numberOfSlots = sc.nextInt();

        ParkingLot parkingLot = ParkingLot.getParkingLot(parkingLotId, numberOfFloor,
                numberOfSlots);
        parkingLot.createParkingLot();
        FreeSlotAvailabilityInfo freeSlotAvailabilityInfo = new FreeSlotAvailabilityInfo(numberOfFloor);

        FreeSlotsCount freeSlotsCount = new FreeSlotsCount();
        FreeSlotsInfo freeSlotsInfo = new FreeSlotsInfo();
        OccupiedSlotsInfo occupiedSlotsInfo = new OccupiedSlotsInfo();
        VEHICLETYPE[] vehicletypes = VEHICLETYPE.values();

        FreeSlot freeSlot = new FreeSlot();

        ParkVehicle parkVehicle = new ParkVehicle();
        UnParkedvehicle unParkedvehicle = new UnParkedvehicle();

        boolean run = true;
        VEHICLETYPE vehicletype = null;
        while (run) {
            System.out.println("Select Command: ");
            COMMANDS[] commands = COMMANDS.values();
            for (int i = 1; i < commands.length; i++) {
                System.out.println(commands[i].ordinal() + ". " + commands[i]);
            }
            int option = sc.nextInt();
            String command = commands[option].getCommand();
            switch (command) {
                case "park_vehicle":
                    System.out.println("Select vehicle type: ");
                    for (VEHICLETYPE vehicletype_ : vehicletypes) {
                        System.out.println((vehicletype_.ordinal() + 1) + ". " + vehicletype_);
                    }
                    int selectedVehicleIdx = sc.nextInt() - 1;
                    sc.nextLine();
                    if (0 <= selectedVehicleIdx && selectedVehicleIdx < vehicletypes.length) {
                        vehicletype = vehicletypes[selectedVehicleIdx];
                    } else {
                        System.out.println("Select Correct Vehicle Type");
                        break;
                    }
                    String vehicle = vehicletypes[selectedVehicleIdx].getVehicleType();
                    boolean isSlotAvailable = freeSlotAvailabilityInfo.isSlotAvailable(vehicletype);
                    if (isSlotAvailable) {
                        String registrationNumber = sc.nextLine();
                        String color = sc.nextLine();
                        int[] availableSlot = freeSlot.geFreeSlot(parkingLot.getParkingLotFloors(), vehicletype);
                        System.out.println("Slot: " + availableSlot[0] + " " + availableSlot[1]);
                        switch (vehicle) {
                            case "TRUCK":
                                freeSlotAvailabilityInfo.updateFloorInfo(availableSlot[0], vehicletype, false);
                                break;
                            case "BIKE":
                                if (availableSlot[1] == 2) {
                                    freeSlotAvailabilityInfo.updateFloorInfo(availableSlot[0], vehicletype, false);
                                }
                                break;
                            case "CAR":
                                if (availableSlot[1] == numberOfSlots - 1) {
                                    freeSlotAvailabilityInfo.updateFloorInfo(availableSlot[0], vehicletype, false);
                                }
                                break;
                        }
                        Slot bookedSlot = parkVehicle.vehicleParked(parkingLotId, availableSlot[0], availableSlot[1],
                                vehicletype, registrationNumber, color);
                        parkingLot.updateParkingLotFloor(bookedSlot, availableSlot[0], availableSlot[1]);

                    } else {
                        System.out.println("Parking Lot Full");
                    }

                    break;
                case "unpark_vehicle":
                    sc.nextLine();
                    System.out.println("Enter Ticket Id: ");
                    String ticketId = sc.nextLine();
                    unParkedvehicle.unParkedvehicle(parkingLot, ticketId);
                    break;
                case "display":
                    DISPLAYTYPE[] displaytypes = DISPLAYTYPE.values();
                    for (int i = 0; i < displaytypes.length; i++) {
                        System.out.println((i + 1) + ". " + displaytypes[i]);
                    }
                    int selectedDisplayType = sc.nextInt() - 1;
                    String displayType = "";

                    if (0 <= selectedDisplayType && selectedDisplayType < displaytypes.length) {
                        displayType = displaytypes[selectedDisplayType].getDisplatType();
                        System.out.println("Select vehicle type: ");
                        for (VEHICLETYPE vehicletype_ : vehicletypes) {
                            System.out.println((vehicletype_.ordinal() + 1) + ". " + vehicletype_);
                        }
                        int selectedVehicle = sc.nextInt() - 1;
                        if (0 <= selectedVehicle && selectedVehicle < vehicletypes.length) {
                            vehicletype = vehicletypes[selectedVehicle];
                        } else {
                            System.out.println("Select Correct Vehicle Type");
                            break;
                        }
                    }

                    switch (displayType) {
                        case "free_count":
                            freeSlotsCount.getFreeSlotsCountInfo(parkingLot.getParkingLotFloors(), vehicletype);
                            break;
                        case "free_slots":
                            freeSlotsInfo.getFreeSlotsInfo(parkingLot.getParkingLotFloors(), vehicletype);
                            break;
                        case "occupied_slots":
                            occupiedSlotsInfo.getOccupiedSlotsInfo(parkingLot.getParkingLotFloors(), vehicletype);
                            break;
                        default:
                            System.out.println("Select Correct Display Type");
                            break;
                    }
                    break;
                case "exit":
                    System.out.println("Thanks for using our Service!!");
                    sc.close();
                    run = false;
                    break;
            }

        }

    }
}
