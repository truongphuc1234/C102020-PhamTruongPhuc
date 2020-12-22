package commons.convert_csv;

import models.House;

public class FormatCSV_House implements FormatCSV<House> {

    private static final String HEADER = "id,name,useArea,rentCost,maximumPeople,rentType,roomStandard,otherUtilities,numberOfFloor";

    @Override
    public String getHeader() {
        return HEADER;
    }

    @Override
    public String convertToStringCSV(House house) {
        return house.getId() + COMMA_DELIMITER
                + house.getName() + COMMA_DELIMITER
                + house.getUseArea() + COMMA_DELIMITER
                + house.getRentCost() + COMMA_DELIMITER
                + house.getMaximumPeople() + COMMA_DELIMITER
                + house.getRentType() + COMMA_DELIMITER
                + house.getRoomStandard() + COMMA_DELIMITER
                + house.getOtherUtilities() + COMMA_DELIMITER
                + house.getNumberOfFloor();
    }

    @Override
    public House getObjectByStringCSV(String string) {
        String[] stringArr = string.split(",");
        return new House(stringArr[0],
                stringArr[1],
                Double.parseDouble(stringArr[2]),
                Double.parseDouble(stringArr[3]),
                Integer.parseInt(stringArr[4]),
                stringArr[5],
                stringArr[6],
                stringArr[7],
                Integer.parseInt(stringArr[8]));
    }
}
