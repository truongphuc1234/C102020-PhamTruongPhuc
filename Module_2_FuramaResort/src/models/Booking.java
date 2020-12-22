package models;

public class Booking {
    private String customerId;
    private String serviceId;

    public Booking(String customerId, String serviceId) {
        this.customerId = customerId;
        this.serviceId = serviceId;
    }

    public Booking() {
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }
}
