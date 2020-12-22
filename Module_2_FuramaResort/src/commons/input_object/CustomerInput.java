package commons.input_object;

import commons.exception.*;
import commons.validation_data.ValidationCustomer;
import models.Customer;

import java.util.Scanner;

public class CustomerInput implements Input<Customer> {
    private static Scanner scanner = new Scanner(System.in);

    public Customer create() {
        String name = null;
        ValidationCustomer validation = new ValidationCustomer();
        do {
            try {
                System.out.print("Enter your full name: ");
                name = validation.validateName(scanner.nextLine());
            } catch (NameException e) {
                System.err.println(e.getMessage());
            }
        } while (name == null);

        String birthday = null;
        do {
            try {
                System.out.print("Enter your birthday: ");
                birthday = validation.validateBirthday(scanner.nextLine());
            } catch (BirthdayException e) {
                System.err.println(e.getMessage());
            }
        } while (birthday == null);

        String gender = null;
        do {
            try {
                System.out.print("Enter your gender: ");
                gender = validation.validateGender(scanner.nextLine());
            } catch (GenderException e) {
                System.err.println(e.getMessage());
            }
        } while (gender == null);

        String identity = null;
        do {
            try {
                System.out.print("Enter your identity: ");
                identity = validation.validateID(scanner.nextLine());
            } catch (IDCardException e) {
                System.err.println(e.getMessage());
            }
        } while (identity == null);

        String phoneNumber;
        do {
            System.out.print("Enter your phone number: ");
            phoneNumber = scanner.nextLine();
        } while (phoneNumber == null);

        String email = null;
        do {
            try {
                System.out.print("Enter your email: ");
                email = validation.validateEmail(scanner.nextLine());
            } catch (EmailException e) {
                System.err.println(e.getMessage());
            }
        } while (email == null);

        String address;
        do {
            System.out.print("Enter your address: ");
            address = scanner.nextLine();
        } while (address == null);

        String typeCustomer = null;
        do {
            try {
                System.out.print("Enter type of customer: ");
                typeCustomer = validation.validateCustomerType(scanner.nextLine());
            } catch (InvalidInputException e) {
                System.err.println(e.getMessage());
            }
        } while (typeCustomer == null);

        return new Customer(name, birthday, gender, identity, phoneNumber, email, typeCustomer, address);
    }
}
