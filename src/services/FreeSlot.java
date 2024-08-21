package services;

import java.util.Arrays;
import java.util.List;

import enums.VEHICLETYPE;
import model.Floor;
import model.Slot;

public class FreeSlot {
    public int[] geFreeSlot(List<Floor> floors, VEHICLETYPE vehicletype) {
        String vehicle = vehicletype.getVehicleType();
        int[] slot = new int[2];
        Arrays.fill(slot, -1);
        for (int i = 0; i < floors.size(); i++) {
            Slot[] slots = floors.get(i).getSlots();
            switch (vehicle) {
                case "TRUCK":
                    if (slots[0] == null) {
                       slot = new int[]{i, 0};
                    }
                    break;
                case "BIKE":
                    for (int j = 1; j <= 2; j++) {
                        if (slots[j] == null) {
                            slot = new int[]{i, j};
                            break;
                        }
                    }
                    break;
                case "CAR":
                    for (int j = 3; j < slots.length; j++) {
                        if (slots[j] == null) {
                            slot = new int[]{i, j};
                            break;
                        }
                    }
                    break;
            }
            if(slot[0] != -1){
                break;
            }
        }
        return slot;
    }
}
