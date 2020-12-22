package commons.constant;

public enum FilePath {
    CUSTOMER("data/Customer.csv"),
    VILLA("data/Villa.csv"),
    HOUSE("data/House.csv"),
    ROOM("data/Room.csv"),
    BOOKING("data/Booking.csv"),
    EMPLOYEE("data/Employee.csv");


    private final String filePath;

    FilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }
}
