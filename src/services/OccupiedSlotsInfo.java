package services;

import java.util.List;

import enums.VEHICLETYPE;
import model.Floor;
import model.Slot;

public class OccupiedSlotsInfo {
    public void getOccupiedSlotsInfo(List<Floor> floors, VEHICLETYPE vehicletype) {
        String vehicle = vehicletype.getVehicleType();
        for (int i = 0; i < floors.size(); i++) {
            Slot[] slots = floors.get(i).getSlots();
            switch (vehicle) {
                case "TRUCK":
                    System.out.print("Occupied slots for TRUCK on Floor " + (i + 1) + ": ");
                    if (slots[0] != null) {
                        System.out.print(1);
                    }
                    break;
                case "BIKE":
                    System.out.print("Occupied slots for BIKE on Floor " + (i + 1) + ": ");
                    for (int j = 1; j <= 2; j++) {
                        if (slots[j] != null) {
                            System.out.print(j + 1);
                            if (j != 2) {
                                System.out.print(", ");
                            }
                        }
                    }
                    break;
                case "CAR":
                    System.out.print("Occupied slots for CAR on Floor " + (i + 1) + ": ");
                    for (int j = 3; j < slots.length; j++) {
                        if (slots[j] != null) {
                            System.out.print(j + 1);
                            if (j != slots.length - 1) {
                                System.out.print(", ");
                            }
                        }
                    }
                    break;
            }
            System.out.println();
        }
    }
}
