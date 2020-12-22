package commons.validation_data;

import commons.exception.InvalidInputException;

public class ValidationService {
    public String validateName(String inputString) throws InvalidInputException {
        boolean isValid = !Character.isLowerCase(inputString.charAt(0));
        if (isValid)
            return inputString;
        throw new InvalidInputException("The first letter must be UPPERCASE letter");
    }

    public double validateUsedArea(String inputString) throws InvalidInputException {
        try {
            double areaDouble = Double.parseDouble(inputString);
            if (areaDouble > 30)
                return areaDouble;
            throw new InvalidInputException("The area must be large than 30m2");
        } catch (Exception e) {
            throw new InvalidInputException("The area must be a number");
        }
    }

    public double validateRentCost(String inputString) throws InvalidInputException {
        double rentCostDouble;
        try {
            rentCostDouble = Double.parseDouble(inputString);
            if (rentCostDouble > 0)
                return rentCostDouble;
            throw new InvalidInputException("The area must be a positive");
        } catch (Exception e) {
            throw new InvalidInputException("The area must be a number");
        }
    }

    public int validateMaximumPeople(String inputString) throws InvalidInputException {
        int maximumPeople;
        try {
            maximumPeople = Integer.parseInt(inputString);
            if (maximumPeople > 0 && maximumPeople < 20)
                return maximumPeople;
            throw new InvalidInputException("Number of people must be positive and small than 20");
        } catch (Exception e) {
            throw new InvalidInputException("Number of people must be an integer number");
        }
    }

    public String validateServiceType(String inputString) throws InvalidInputException {
        inputString = inputString.toLowerCase();
        boolean inValid = inputString.equals("year") || inputString.equals("month") || inputString.equals("day") || inputString.equals("hour");
        if (inValid)
            return inputString.substring(0, 1).toUpperCase() + inputString.substring(1);
        throw new InvalidInputException("Service type must be following value : Year / Month / Day / Hour");
    }

    public String validateID(String inputString, String className) throws InvalidInputException {

        String abbreviation = null;
        switch (className) {
            case "villa":
                abbreviation = "VL";
                break;
            case "house":
                abbreviation = "HO";
                break;
            case "room":
                abbreviation = "RO";
                break;
            default:
                break;
        }
        if (!inputString.matches("^SV" + abbreviation + "-\\d{4}$"))
            throw new InvalidInputException("Service ID must be in format \"SV" + abbreviation + "-XXXX\" where X is digit 0-9");
        return inputString;
    }

    public String validateRoomStandard(String inputString) throws InvalidInputException {
        boolean isValid = !Character.isLowerCase(inputString.charAt(0));
        if (isValid)
            return inputString;
        throw new InvalidInputException("The first letter must be UPPERCASE letter");
    }

    public String validateOtherUtilities(String inputString) throws InvalidInputException {
        boolean isValid = !Character.isLowerCase(inputString.charAt(0));
        if (isValid)
            return inputString;
        throw new InvalidInputException("The first letter must be UPPERCASE letter");
    }

    public double validateAreaPool(String inputString) throws InvalidInputException {
        try {
            double areaDouble = Double.parseDouble(inputString);
            if (areaDouble > 30)
                return areaDouble;
            throw new InvalidInputException("The pool area must be large than 30m2");
        } catch (Exception e) {
            throw new InvalidInputException("The pool area must be a number");
        }
    }

    public int validateNumberOfFloor(String inputString) throws InvalidInputException {
        int numberOfFloor;
        try {
            numberOfFloor = Integer.parseInt(inputString);
            if (numberOfFloor > 0)
                return numberOfFloor;
            throw new InvalidInputException("Number of floors must be positive");
        } catch (Exception e) {
            throw new InvalidInputException("Number of floors must be an integer number");
        }
    }

    public String validateFreeAddingService(String inputString) throws InvalidInputException {
        inputString = inputString.toLowerCase();
        boolean inValid = inputString.equals("message") || inputString.equals("karaoke") || inputString.equals("food") || inputString.equals("drink") || inputString.equals("car");
        if (inValid)
            return inputString.substring(0, 1).toUpperCase() + inputString.substring(1);
        throw new InvalidInputException("Free adding service must be following value : Massage / Karaoke / Food / Drink / Car");
    }
}
