package controllers;

import commons.comparator.ComparatorCustomerByName;
import commons.constant.FilePath;
import commons.convert_csv.ConverterCSV;
import commons.convert_csv.FormatCSV_Customer;
import commons.input_object.CustomerInput;
import models.Customer;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class CustomerController {
    private final ConverterCSV<Customer> converter = new ConverterCSV<>(new FormatCSV_Customer());
    private List<Customer> list;

    public CustomerController() {
        this.list = converter.readFileToList(FilePath.CUSTOMER.getFilePath());
    }

    public void addNewCustomer() {
        CustomerInput customerInput = new CustomerInput();
        Customer newCustomer = customerInput.create();
        list.add(newCustomer);
        converter.writeListToCSVFile(list, FilePath.CUSTOMER.getFilePath());
    }

    public void sortListCustomer() {
        List<Customer> list = converter.readFileToList(FilePath.CUSTOMER.getFilePath());
        list.sort(new ComparatorCustomerByName());
        new ConverterCSV<>(new FormatCSV_Customer()).writeListToCSVFile(list, FilePath.CUSTOMER.getFilePath());
        for (Customer customer : list) {
            customer.showInfo();
        }
    }

    public void cinema() {
        Scanner scanner = new Scanner(System.in);
        List<Customer> list = converter.readFileToList(FilePath.CUSTOMER.getFilePath());
        for (Customer customer : list) {
            System.out.println(customer.getName() + " " + customer.getIdentity());
        }
        Queue<Customer> customers = new LinkedList<>();
        String choice;
        do {
            System.out.println("Insert customer Id for 4D Cinema:(Press Q to quit)");
            choice = scanner.nextLine();
            for (Customer customer : list) {
                if (customer.getIdentity().equals(choice))
                    customers.add(customer);
            }
        } while (!choice.equals("Q"));
        while (!customers.isEmpty()){
            System.out.println(customers.poll().getName());
        }
    }

    public static void main(String[] args) {
        CustomerController controller = new CustomerController();
        controller.cinema();
    }

}
