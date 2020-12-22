package models;

public class House extends Services {
    private String roomStandard;
    private String otherUtilities;
    private int numberOfFloor;

    public House(String id, String name, double useArea, double rentCost, int maximumPeople, String rentType, String roomStandard, String otherUtilities, int numberOfFloor) {
        super(id, name, useArea, rentCost, maximumPeople, rentType);
        this.roomStandard = roomStandard;
        this.otherUtilities = otherUtilities;
        this.numberOfFloor = numberOfFloor;
    }

    public House() {
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
                "\nTiêu chuẩn phòng: " + this.roomStandard +
                "\nMô tả tiện nghi khác: " + this.otherUtilities +
                "\nSố tầng: " + this.numberOfFloor + "(tầng)\n\\");
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public String getOtherUtilities() {
        return otherUtilities;
    }

    public void setOtherUtilities(String otherUtilities) {
        this.otherUtilities = otherUtilities;
    }

    public int getNumberOfFloor() {
        return numberOfFloor;
    }

    public void setNumberOfFloor(int numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
    }
}
