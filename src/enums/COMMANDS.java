package enums;

public enum COMMANDS {
    create_parking_lot("create_parking_lot"),
    park_vehicle("park_vehicle"),
    unpark_vehicle("unpark_vehicle"),
    display("display"),
    exit("exit");

    String command;

    private COMMANDS(String command) {
        this.command = command;
    }

    public String getCommand(){
        return command;
    }
}