package services;

import java.util.List;

import enums.VEHICLETYPE;
import model.Floor;
import model.Slot;

public class FreeSlotsCount {
    public void getFreeSlotsCountInfo(List<Floor> floors, VEHICLETYPE vehicletype) {
        String vehicle = vehicletype.getVehicleType();
        for (int i = 0; i < floors.size(); i++) {
            Slot[] slots = floors.get(i).getSlots();
            int freeSlotsCount = 0;
            switch (vehicle) {
                case "TRUCK":
                    if (slots[0] == null) {
                        freeSlotsCount = 1;
                    }
                    break;
                case "BIKE":
                    for (int j = 1; j <= 2; j++) {
                        if (slots[j] == null) {
                            freeSlotsCount++;
                        }
                    }
                    break;
                case "CAR":
                    for (int j = 3; j < slots.length; j++) {
                        if (slots[j] == null) {
                            freeSlotsCount++;
                        }
                    }
                    break;
            }
            System.out.println("No. of free slots for " + vehicle + " on Floor " + (i + 1) + ": " + freeSlotsCount);
        }
    }
}
