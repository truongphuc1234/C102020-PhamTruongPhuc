package commons.input_object;

import commons.exception.InvalidInputException;
import models.House;

public class HouseInput extends ServiceInput<House> {

    @Override
    public House create() {
        House house = new House();
        String id = null;
        do {
            try {
                System.out.print("Enter the product code: ");
                id = validation.validateID(scanner.nextLine(), "villa");
            } catch (InvalidInputException e) {
                System.err.println(e.getMessage());
            }
        } while (id == null);

        super.create(house);

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

        int numberOfFloor = 0;
        do {
            try {
                System.out.print("Enter number of floor: ");
                numberOfFloor = validation.validateNumberOfFloor(scanner.nextLine());
            } catch (InvalidInputException e) {
                System.err.println(e.getMessage());
            }
        } while (numberOfFloor == 0);

        house.setId(id);
        house.setRoomStandard(roomStandard);
        house.setOtherUtilities(otherUtilities);
        house.setNumberOfFloor(numberOfFloor);

        return house;
    }
}
