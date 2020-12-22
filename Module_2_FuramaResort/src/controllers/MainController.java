package controllers;

import java.util.Scanner;

public class MainController {

    public final static Scanner scanner = new Scanner(System.in);

    private void displayMainMenu() {
        int choice;
        do {
            System.out.println("Main Menu" +
                    "\n1.\tAdd New Services" +
                    "\n2.\tShow Services" +
                    "\n3.\tAdd New Customer" +
                    "\n4.\tShow Information of Customer" +
                    "\n5.\tAdd New Booking" +
                    "\n6.\tShow Information of Employee" +
                    "\n7.\tExit.");
            System.out.print("Enter your choice:\t");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    new ServiceController().addNewService();
                    break;
                case 2:
                    new ServiceController().showServices();
                    break;
                case 3:
                    new CustomerController().addNewCustomer();
                    break;
                case 4:
                    new CustomerController().sortListCustomer();
                    break;
                case 5:
                    new BookingController().addNewBooking();
                    break;
                case 6:
                    new EmployeeController().displayEmployeeMenu();
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please enter your choice again!");
                    break;
            }
        } while (true);
    }

    public static void main(String[] args) {
        MainController controller = new MainController();
        controller.displayMainMenu();
    }
}
