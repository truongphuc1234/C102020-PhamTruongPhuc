package commons.input_object;

import commons.constant.FilePath;
import commons.convert_csv.ConverterCSV;
import commons.convert_csv.FormatCSV_Customer;
import commons.convert_csv.FormatCSV_Villa;
import models.Booking;
import models.Customer;
import models.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookingInput implements Input<Booking> {
    private static Scanner scanner = new Scanner(System.in);

    private void displayCustomerInfo(List<Customer> customerList) {
        for (int i = 0; i < customerList.size(); i++) {
            System.out.println((i + 1) + ")");
            customerList.get(i).showInfo();
            System.out.println();
        }
    }

    private void displayServiceInfo(List<? extends Services> servicesList) {
        for (int i = 0; i < servicesList.size(); i++) {
            System.out.println((i + 1) + ")");
            servicesList.get(i).showInfor();
            System.out.println();
        }
    }

    private static int getChoice(int size) {
        do {
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice > 0 || choice <= size)
                return choice;
            System.out.print("Invalid choice. Please choose your choice again: ");
        } while (true);
    }

    public Booking create() {

        List<Customer> listCustomer = new ConverterCSV<>(new FormatCSV_Customer()).readFileToList(FilePath.CUSTOMER.getFilePath());
        System.out.println("Choose customer as list below:");

        displayCustomerInfo(listCustomer);
        int choiceCustomer = getChoice(listCustomer.size());

        System.out.println("Choose your type of service: \n1.\tVilla\n2.\tHouse\n3.\tRoom");
        int choice = getChoice(3);

        List<? extends Services> listService = new ArrayList<>();
        switch (choice) {
            case 1:
                listService = new ConverterCSV<>(new FormatCSV_Villa()).readFileToList(FilePath.VILLA.getFilePath());
                break;
            case 2:
                listService = new ConverterCSV<>(new FormatCSV_Villa()).readFileToList(FilePath.HOUSE.getFilePath());
                break;
            case 3:
                listService = new ConverterCSV<>(new FormatCSV_Villa()).readFileToList(FilePath.ROOM.getFilePath());
                break;
        }

        displayServiceInfo(listService);
        int choiceService = getChoice(listService.size());

        String customerId = listCustomer.get(choiceCustomer - 1).getIdentity();
        String serviceId = listService.get(choiceService - 1).getId();

        return new Booking(customerId, serviceId);
    }
}
