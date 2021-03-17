package spring.furama.model.service;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "service")
public class ResortService {

    @Id
    @Column(name = "service_id", nullable = false)
    @Pattern(regexp = "^DV-\\d{4}$", message = "Service ID must be format 'DV-XXXX'(X is number)")
    @NotNull(message = "Service id must be not empty")
    private String serviceId;

    @Column(name = "service_name", nullable = false, length = 45)
    @NotBlank(message = "Name must be not empty")
    @Size(max = 45)
    private String serviceName;

    @Column(name = "service_area")
    @DecimalMin( value = "0.01", message = "Area must be positive")
    private Double serviceArea;

    @Column(name = "service_cost",nullable = false)
    @DecimalMin( value = "0.01", message = "Cost must be positive")
    @NotNull(message = "Field must not be empty")
    private Double serviceCost;

    @Column(name = "service_max_people")
    @Min(value = 1, message = "Max people must be positive")
    private Integer serviceMaxPeople;

    @ManyToOne
    @JoinColumn(name = "rent_type_id", referencedColumnName = "rent_type_id",nullable = false)
    @NotNull(message = "Rent type must not be empty")
    private RentType rentType;

    @ManyToOne
    @JoinColumn(name = "service_type_id", referencedColumnName = "service_type_id")
    @NotNull(message = "Service type must not be empty")
    private ServiceType serviceType;

    @Column(name = "standard_room")
    private String standardRoom;

    @Column(name = "description_other_convenience")
    private String descriptionOtherConvenience;

    @Column(name = "pool_area")
    @DecimalMin( value = "0.01", message = "Pool area must be positive")
    private Double poolArea;

    @Column(name = "number_of_floors")
    @Min(value = 1, message = "Number of floors must be positive")
    private Integer numberOfFloors;

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Double getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(Double serviceArea) {
        this.serviceArea = serviceArea;
    }

    public Double getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(Double serviceCost) {
        this.serviceCost = serviceCost;
    }

    public Integer getServiceMaxPeople() {
        return serviceMaxPeople;
    }

    public void setServiceMaxPeople(Integer serviceMaxPeople) {
        this.serviceMaxPeople = serviceMaxPeople;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public Double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(Double poolArea) {
        this.poolArea = poolArea;
    }

    public Integer getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(Integer numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }
}
