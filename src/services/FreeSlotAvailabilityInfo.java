package services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import enums.VEHICLETYPE;

/**
 * FreeSlotAvailabilityInfo
 */
public class FreeSlotAvailabilityInfo {
    List<Map<VEHICLETYPE, Boolean>> slotAvailabilityList;

    public FreeSlotAvailabilityInfo(int floors){
        slotAvailabilityList = new ArrayList<>();
        VEHICLETYPE[] vehicletypes = VEHICLETYPE.values();
        for(int i = 0; i < floors; i++){
            slotAvailabilityList.add(new HashMap<>());
            for(VEHICLETYPE vehicletype : vehicletypes){
                slotAvailabilityList.get(i).put(vehicletype, true);
            }
        }
    }

    public void updateFloorInfo(int floorNumber, VEHICLETYPE vehicletype, boolean condition) {
        slotAvailabilityList.get(floorNumber).put(vehicletype, condition);
    }

    public boolean isSlotAvailable(VEHICLETYPE vehicletype){
        for(Map<VEHICLETYPE, Boolean> map : slotAvailabilityList){
            if(map.get(vehicletype)){
                return true;
            }
        }
        return false;
    }
    
}