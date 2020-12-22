package commons.convert_csv;

import models.Villa;

public class FormatCSV_Villa implements FormatCSV<Villa> {
    private static final String HEADER = "id,name,useArea,rentCost,maximumPeople,rentType,roomStandard,otherUtilities,areaPool,numberOfFloor";

    @Override
    public String getHeader() {
        return HEADER;
    }

    @Override
    public String convertToStringCSV(Villa villa) {
        return villa.getId() + COMMA_DELIMITER
                + villa.getName() + COMMA_DELIMITER
                + villa.getUseArea() + COMMA_DELIMITER
                + villa.getRentCost() + COMMA_DELIMITER
                + villa.getMaximumPeople() + COMMA_DELIMITER
                + villa.getRentType() + COMMA_DELIMITER
                + villa.getRoomStandard() + COMMA_DELIMITER
                + villa.getOtherUtilities() + COMMA_DELIMITER
                + villa.getAreaPool() + COMMA_DELIMITER
                + villa.getNumberOfFloor();
    }

    @Override
    public Villa getObjectByStringCSV(String string) {
        String[] stringArr = string.split(",");
        return new Villa(stringArr[0],
                stringArr[1],
                Double.parseDouble(stringArr[2]),
                Double.parseDouble(stringArr[3]),
                Integer.parseInt(stringArr[4]),
                stringArr[5],
                stringArr[6],
                stringArr[7],
                Double.parseDouble(stringArr[8]),
                Integer.parseInt(stringArr[9]));
    }

}
