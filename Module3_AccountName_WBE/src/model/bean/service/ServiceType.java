package model.bean.service;

public class ServiceType {
    private int serviceTypeId;
    private int serviceTypeName;

    public ServiceType() {
    }

    public ServiceType(int serviceTypeId, int serviceTypeName) {
        this.serviceTypeId = serviceTypeId;
        this.serviceTypeName = serviceTypeName;
    }

    public int getServiceTypeId() {
        return serviceTypeId;
    }

    public void setServiceTypeId(int serviceTypeId) {
        this.serviceTypeId = serviceTypeId;
    }

    public int getServiceTypeName() {
        return serviceTypeName;
    }

    public void setServiceTypeName(int serviceTypeName) {
        this.serviceTypeName = serviceTypeName;
    }
}
