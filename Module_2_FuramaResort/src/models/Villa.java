package models;

public class Villa extends Services {
    private String roomStandard;
    private String otherUtilities;
    private double areaPool;
    private int numberOfFloor;

    public Villa(String id, String name, double useArea, double rentCost, int maximumPeople, String rentType, String roomStandard, String otherUtilities, double areaPool, int numberOfFloor) {
        super(id, name, useArea, rentCost, maximumPeople, rentType);
        this.roomStandard = roomStandard;
        this.otherUtilities = otherUtilities;
        this.areaPool = areaPool;
        this.numberOfFloor = numberOfFloor;
    }

    public Villa() {
    }

    @Override
    public void showInfor() {
        System.out.println("Villa: " +
                "\nID: " + super.getId() +
                "\nTên: " + super.getName() +
                "\nDiện tích sử dụng: " + super.getUseArea() + "(m2)" +
                "\nChi phí thuê: " + super.getRentCost() + "(USD)" +
                "\nSố lượng người tối đa: " + super.getMaximumPeople() + "(người)" +
                "\nKiểu thuê: " + super.getRentType() +
                "\nTiêu chuẩn phòng: " + this.roomStandard +
                "\nMô tả tiện nghi khác: " + this.otherUtilities +
                "\nDiện tích hồ bơi: " + this.areaPool + "(m2)" +
                "\nSố tầng:" + this.numberOfFloor + "(tầng)\n\\");
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

    public double getAreaPool() {
        return areaPool;
    }

    public void setAreaPool(double areaPool) {
        this.areaPool = areaPool;
    }

    public int getNumberOfFloor() {
        return numberOfFloor;
    }

    public void setNumberOfFloor(int numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
    }
}
