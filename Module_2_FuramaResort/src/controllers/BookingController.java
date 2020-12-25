package controllers;

import commons.constant.FilePath;
import commons.convert_csv.ConverterCSV;
import commons.convert_csv.FormatCSV_Booking;
import commons.input_object.BookingInput;
import models.Booking;


import java.util.List;

public class BookingController {
    private static final ConverterCSV<Booking> converter = new ConverterCSV<>(new FormatCSV_Booking());
    private List<Booking> bookingList;

    public BookingController() {
        this.bookingList = converter.readFileToList(FilePath.BOOKING.getFilePath());
    }

    public void addNewBooking() {
        Booking booking = new BookingInput().create();
        bookingList.add(booking);
        converter.writeListToCSVFile(bookingList,FilePath.BOOKING.getFilePath());
    }
}
