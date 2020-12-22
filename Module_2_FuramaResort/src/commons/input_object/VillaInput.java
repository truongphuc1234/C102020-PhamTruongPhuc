package commons.input_object;

import commons.exception.InvalidInputException;
import models.Villa;

public class VillaInput extends ServiceInput<Villa>{

    public Villa create() {
        Villa villa = new Villa();
        String id = null;
        do {
            try {
                System.out.print("Enter the product code: ");
                id = validation.validateID(scanner.nextLine(), "villa");
            } catch (InvalidInputException e) {
                System.err.println(e.getMessage());
            }
        } while (id == null);

        super.create(villa);

        String roomStandard = null;
        do {
            try {
                System.out.print("Enter the room standard: ");
                roomStandard =validation.validateRoomStandard(scanner.nextLine());
            } catch (InvalidInputException e) {
                System.err.println(e.getMessage());
            }
        } while(roomStandard == null);

        String otherUtilities = null;
        do {
            try {
                System.out.print("Enter other utilities: ");
                otherUtilities = validation.validateOtherUtilities(scanner.nextLine());
            } catch (InvalidInputException e) {
                System.err.println(e.getMessage());
            }
        } while (otherUtilities == null);

        double areaPool = 0;
        do {
            try {
                System.out.print("Enter area pool: ");
                areaPool = validation.validateAreaPool(scanner.nextLine());
            } catch (InvalidInputException e) {
                System.err.println(e.getMessage());
            }
        } while (areaPool == 0);

        int numberOfFloor = 0;
        do {
            try {
                System.out.print("Enter number of floor: ");
                numberOfFloor = validation.validateNumberOfFloor(scanner.nextLine());
            } catch (InvalidInputException e) {
                System.err.println(e.getMessage());
            }
        } while (numberOfFloor == 0);

        villa.setId(id);
        villa.setRoomStandard(roomStandard);
        villa.setOtherUtilities(otherUtilities);
        villa.setAreaPool(areaPool);
        villa.setNumberOfFloor(numberOfFloor);

        return villa;
    }

}
