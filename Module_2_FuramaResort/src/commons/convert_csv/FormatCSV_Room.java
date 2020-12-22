package commons.convert_csv;

import models.Room;

public class FormatCSV_Room implements FormatCSV<Room> {
    private static final String HEADER = "id,name,useArea,rentCost,maximumPeople,rentType,";

    @Override
    public String getHeader() {
        return HEADER;
    }

    @Override
    public String convertToStringCSV(Room room) {
        return room.getId() + COMMA_DELIMITER
                + room.getName() + COMMA_DELIMITER
                + room.getUseArea() + COMMA_DELIMITER
                + room.getRentCost() + COMMA_DELIMITER
                + room.getMaximumPeople() + COMMA_DELIMITER
                + room.getRentType() + COMMA_DELIMITER
                + room.getFreeAddingService();
    }

    @Override
    public Room getObjectByStringCSV(String string) {
        String[] stringArr = string.split(",");
        return new Room(stringArr[0],
                stringArr[1],
                Double.parseDouble(stringArr[2]),
                Double.parseDouble(stringArr[3]),
                Integer.parseInt(stringArr[4]),
                stringArr[5],
                stringArr[6]);
    }
}
