package commons.input_object;

import commons.exception.InvalidInputException;
import commons.exception.NameException;
import commons.validation_data.ValidationEmployee;
import models.Employee;

import java.util.Scanner;

public class EmployeeInput implements Input<Employee> {
    private static Scanner scanner = new Scanner(System.in);

    @Override
    public Employee create() {
        String name = null;
        ValidationEmployee validation = new ValidationEmployee();
        do {
            try {
                System.out.print("Enter your full name: ");
                name = validation.validateName(scanner.nextLine());
            } catch (NameException e) {
                System.err.println(e.getMessage());
            }
        } while (name == null);


        String id = null;
        do {
            try {
                System.out.print("Enter your id: ");
                id = validation.validateID(scanner.nextLine());
            } catch (InvalidInputException e) {
                System.err.println(e.getMessage());
            }
        } while (id == null);

        String address;
        do {
            System.out.print("Enter your address: ");
            address = scanner.nextLine();
        } while (address == null);

        return new Employee(id,name,address);
    }
}
