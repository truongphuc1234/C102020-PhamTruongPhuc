package commons.input_object;

import commons.exception.InvalidInputException;
import models.Room;

public class RoomInput extends ServiceInput<Room> {

    @Override
    public Room create() {
        Room room = new Room();
        String id = null;
        do {
            try {
                System.out.print("Enter the product code: ");
                id = validation.validateID(scanner.nextLine(), "villa");
            } catch (InvalidInputException e) {
                System.err.println(e.getMessage());
            }
        } while (id == null);

        super.create(room);

        String freeAddingService = null;
        do {
            try {
                System.out.print("Enter the free adding service: ");
                freeAddingService = validation.validateFreeAddingService(scanner.nextLine());
            } catch (InvalidInputException e) {
                System.err.println(e.getMessage());
            }
        } while (freeAddingService == null);

        room.setFreeAddingService(freeAddingService);

        return room;
    }
}

