package commons.convert_csv;

import models.Booking;

public class FormatCSV_Booking implements FormatCSV<Booking> {
    private static final String HEADER = "id_customer,id_booking";

    @Override
    public String getHeader() {
        return HEADER;
    }

    @Override
    public String convertToStringCSV(Booking booking) {
        return booking.getCustomerId() + COMMA_DELIMITER +
                booking.getServiceId();
    }

    @Override
    public Booking getObjectByStringCSV(String string) {
        String[] stringArr = string.split(",");
        return new Booking(stringArr[0], stringArr[1]);
    }
}
