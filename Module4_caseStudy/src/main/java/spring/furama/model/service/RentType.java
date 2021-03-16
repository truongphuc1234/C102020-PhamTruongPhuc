package spring.furama.model.service;

import javax.persistence.*;

@Entity
@Table(name = "rent_type")
public class RentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rent_type_id")
    private int rentTypeId;
    @Column(name = "rent_type_name", nullable = false)
    private String rentTypeName;
    @Column(name = "rent_type_cost", nullable = false)
    private double rentTypeCost;

    public int getRentTypeId() {
        return rentTypeId;
    }

    public void setRentTypeId(int rentTypeId) {
        this.rentTypeId = rentTypeId;
    }

    public String getRentTypeName() {
        return rentTypeName;
    }

    public void setRentTypeName(String rentTypeName) {
        this.rentTypeName = rentTypeName;
    }

    public double getRentTypeCost() {
        return rentTypeCost;
    }

    public void setRentTypeCost(double rentTypeCost) {
        this.rentTypeCost = rentTypeCost;
    }
}
