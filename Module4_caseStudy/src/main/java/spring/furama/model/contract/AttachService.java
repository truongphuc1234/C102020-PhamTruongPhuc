package spring.furama.model.contract;

import org.springframework.stereotype.Controller;

import javax.persistence.*;

@Entity
@Table
public class AttachService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attach_service_id")
    private int attachServiceId;
    @Column(name = "attach_service_name", nullable = false, unique = true)
    private String attachServiceName;
    @Column(name = "attach_service_cost", nullable = false)
    private double attachServiceCost;
    @Column(name = "attach_service_unit",nullable = false)
    private int attachServiceUnit;
    @Column(name = "attach_service_status")
    private String attachServiceStatus;


}
