package enums;

public enum VEHICLETYPE{
    TRUCK("TRUCK"),
    BIKE("BIKE"),
    CAR("CAR");

    private String vehicleType;

    private VEHICLETYPE(String vehicleType){
        this.vehicleType = vehicleType;
    }

    public String getVehicleType() {
        return vehicleType;
    }
}