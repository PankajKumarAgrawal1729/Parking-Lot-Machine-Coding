package model;

public class Floor {
    Slot[] slots;
    public Floor(int slotSize){
        slots = new Slot[slotSize];
    }
    public Slot[] getSlots() {
        return slots;
    }
    
}
