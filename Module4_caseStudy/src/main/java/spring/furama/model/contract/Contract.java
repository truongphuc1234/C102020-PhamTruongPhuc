package spring.furama.model.contract;

import spring.furama.model.customer.Customer;
import spring.furama.model.employee.Employee;
import spring.furama.model.service.ResortService;

import javax.persistence.*;

@Entity
@Table(name = "contract")
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_id")
    private int contractId;
    @Column(name = "contract_start_date", nullable = false)
    private String contractStartDate;
    @Column(name = "contract_end_date", nullable = false)
    private String contractEndDate;
    @Column(name = "contract_deposit", nullable = false)
    private double contractDeposit;
    @Column(name = "contract_total_money", nullable = false)
    private double contractTotalMoney;
    @ManyToOne
    @JoinColumn(name = "employee_id",referencedColumnName = "employee_id")
    private Employee employee;
    @ManyToOne
    @JoinColumn(name = "customer_id",referencedColumnName = "customer_id")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "service_id",referencedColumnName = "service_id")
    private ResortService service;

    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public String getContractStartDate() {
        return contractStartDate;
    }

    public void setContractStartDate(String contractStartDate) {
        this.contractStartDate = contractStartDate;
    }

    public String getContractEndDate() {
        return contractEndDate;
    }

    public void setContractEndDate(String contractEndDate) {
        this.contractEndDate = contractEndDate;
    }

    public double getContractDeposit() {
        return contractDeposit;
    }

    public void setContractDeposit(double contractDeposit) {
        this.contractDeposit = contractDeposit;
    }

    public double getContractTotalMoney() {
        return contractTotalMoney;
    }

    public void setContractTotalMoney(double contractTotalMoney) {
        this.contractTotalMoney = contractTotalMoney;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ResortService getService() {
        return service;
    }

    public void setService(ResortService service) {
        this.service = service;
    }
}
