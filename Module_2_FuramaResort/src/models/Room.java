package models;

public class Room extends Services {
    private String freeAddingService;

    public Room(String id, String name, double useArea, double rentCost, int maximumPeople, String rentType, String freeAddingService) {
        super(id, name, useArea, rentCost, maximumPeople, rentType);
        this.freeAddingService = freeAddingService;
    }

    public Room() {
    }

    @Override
    public void showInfor() {
        System.out.println("House: " +
                "\nID: " + super.getId() +
                "\nTên: " + super.getName() +
                "\nDiện tích sử dụng: " + super.getUseArea() + "(m2)" +
                "\nChi phí thuê: " + super.getRentCost() + "(USD)" +
                "\nSố lượng người tối đa: " + super.getMaximumPeople() + "(người)" +
                "\nKiểu thuê: " + super.getRentType() +
                "\nDịch vụ miễn phí đi kèm: " + this.freeAddingService + "\n\\");
    }

    public String getFreeAddingService() {
        return freeAddingService;
    }

    public void setFreeAddingService(String freeAddingService) {
        this.freeAddingService = freeAddingService;
    }

}
