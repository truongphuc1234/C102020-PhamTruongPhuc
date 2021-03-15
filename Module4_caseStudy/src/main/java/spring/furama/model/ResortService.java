package spring.furama.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "service")
public class ResortService {


    private String serviceId;
    private String serviceName;
    private double serviceArea;
    private double serviceCost;
    private int serviceMaxPeople;
    private RentType rentType;
    private ServiceType serviceType;
    private String standardRoom;
    private String descriptionOtherConvenience;
    private double poolArea;
    private int numberOfFloors;


}
