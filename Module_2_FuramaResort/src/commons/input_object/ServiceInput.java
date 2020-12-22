package commons.input_object;

import commons.exception.InvalidInputException;
import commons.validation_data.ValidationService;
import models.Services;

import java.util.Scanner;

public abstract class ServiceInput<E extends Services> implements Input<E> {
    protected static Scanner scanner = new Scanner(System.in);
    protected static ValidationService validation = new ValidationService();

    public abstract E create();

    public void create(E services) {
        String name = null;
        do {
            try {
                System.out.print("Enter service name: ");
                name = validation.validateName(scanner.nextLine());
            } catch (InvalidInputException e) {
                System.err.println(e.getMessage());
            }
        } while (name == null);

        double usingArea = 0;
        do {
            try {
                System.out.print("Enter using area: ");
                usingArea = validation.validateUsedArea(scanner.nextLine());
            } catch (InvalidInputException e) {
                System.err.println(e.getMessage());
            }
        } while (usingArea == 0);

        double rentCost = 0;
        do {
            try {
                System.out.print("Enter rent cost: ");
                rentCost = validation.validateRentCost(scanner.nextLine());
            } catch (InvalidInputException e) {
                System.err.println(e.getMessage());
            }
        } while (rentCost == 0);

        int maximumPeople = 0;
        do {
            try {
                System.out.print("Enter maximum people: ");
                maximumPeople = validation.validateMaximumPeople(scanner.nextLine());
            } catch (InvalidInputException e) {
                System.err.println(e.getMessage());
            }
        } while (maximumPeople == 0);

        String rentType = null;
        do {
            try {
                System.out.print("Enter your rent type (Year/Month/Day/Hour) : ");
                rentType = validation.validateServiceType(scanner.nextLine());
            } catch (InvalidInputException e) {
                System.err.println(e.getMessage());
            }
        } while (rentType == null);

        services.setName(name);
        services.setUseArea(usingArea);
        services.setRentCost(rentCost);
        services.setMaximumPeople(maximumPeople);
        services.setRentType(rentType);
    }
}
