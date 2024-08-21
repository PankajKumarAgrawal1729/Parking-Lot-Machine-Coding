package enums;

public enum DISPLAYTYPE {
    free_count("free_count"),
    free_slots("free_slots"),
    occupied_slots("occupied_slots");

    private String displatType;

    private DISPLAYTYPE(String displatType) {
        this.displatType = displatType;
    }

    public String getDisplatType() {
        return displatType;
    }
}
