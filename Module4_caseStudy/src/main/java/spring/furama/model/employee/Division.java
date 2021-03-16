package spring.furama.model.employee;

import javax.persistence.*;

@Entity
@Table(name = "division")
public class Division {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "division_id")
    private int divisionId;

    @Column(name = "division_name",nullable = false, unique = true)
    private String divisionName;

    public int getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(int divisionId) {
        this.divisionId = divisionId;
    }

    public String getDivisionName() {
        return divisionName;
    }

    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }
}
