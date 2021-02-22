package model.bean.service;

public class ServiceView extends Service {
    private String rentTypeName;
    private String serviceTypeName;

    public ServiceView() {
    }

    public ServiceView(String serviceId, String serviceName, int serviceArea, double serviceCost, int serviceMaxPeople, int rentTypeId, int serviceTypeId, String standardRoom, String descriptionOtherConvenience, double poolArea, int numberOfFloor, String rentTypeName, String serviceTypeName) {
        super(serviceId, serviceName, serviceArea, serviceCost, serviceMaxPeople, rentTypeId, serviceTypeId, standardRoom, descriptionOtherConvenience, poolArea, numberOfFloor);
        this.rentTypeName = rentTypeName;
        this.serviceTypeName = serviceTypeName;
    }

    public String getRentTypeName() {
        return rentTypeName;
    }

    public void setRentTypeName(String rentTypeName) {
        this.rentTypeName = rentTypeName;
    }

    public String getServiceTypeName() {
        return serviceTypeName;
    }

    public void setServiceTypeName(String serviceTypeName) {
        this.serviceTypeName = serviceTypeName;
    }
}
