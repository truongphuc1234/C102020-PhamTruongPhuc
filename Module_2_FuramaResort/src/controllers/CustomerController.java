package controllers;

import commons.comparator.ComparatorCustomerByName;
import commons.constant.FilePath;
import commons.convert_csv.ConverterCSV;
import commons.convert_csv.FormatCSV_Customer;
import commons.input_object.CustomerInput;
import models.Customer;

import java.util.List;

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

}
