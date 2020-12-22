package models;

public abstract class Services{

    private String id;
    private String name;
    private double useArea;
    private double rentCost;
    private int maximumPeople;
    private String rentType;

    public Services(String id, String name, double useArea, double rentCost, int maximumPeople, String rentType) {
        this.id = id;
        this.name = name;
        this.useArea = useArea;
        this.rentCost = rentCost;
        this.maximumPeople = maximumPeople;
        this.rentType = rentType;
    }

    Services() {
    }

    public abstract void showInfor();


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getUseArea() {
        return useArea;
    }

    public void setUseArea(double useArea) {
        this.useArea = useArea;
    }

    public double getRentCost() {
        return rentCost;
    }

    public void setRentCost(double rentCost) {
        this.rentCost = rentCost;
    }

    public int getMaximumPeople() {
        return maximumPeople;
    }

    public void setMaximumPeople(int maximumPeople) {
        this.maximumPeople = maximumPeople;
    }

    public String getRentType() {
        return rentType;
    }

    public void setRentType(String rentType) {
        this.rentType = rentType;
    }
}
