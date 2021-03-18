package spring.furama.model.contract;

import spring.furama.model.customer.Customer;
import spring.furama.model.employee.Employee;
import spring.furama.model.service.ResortService;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
@Table(name = "contract")
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_id")
    private Integer contractId;

    @Column(name = "contract_start_date", nullable = false)
    @Pattern(regexp = "^(19|20)\\d{2}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$",message = "Date must be format YYYY-MM-DD")
    @NotNull(message = "Date must be not empty")
    private String contractStartDate;

    @Column(name = "contract_end_date", nullable = false)
    @Pattern(regexp = "^(19|20)\\d{2}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$",message = "Date must be format YYYY-MM-DD")
    @NotNull(message = "Date must be not empty")
    private String contractEndDate;

    @Column(name = "contract_deposit", nullable = false)
    @NotNull(message = "Deposit must not be empty")
    @DecimalMin(value = "0.01", message = "Deposit must be positive number")
    private Double contractDeposit;

    @Column(name = "contract_total_money", nullable = false)
    private Double contractTotalMoney;

    @ManyToOne
    @JoinColumn(name = "employee_id",referencedColumnName = "employee_id")
    @NotNull(message = "Employee must not be empty")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "customer_id",referencedColumnName = "customer_id")
    @NotNull(message = "Customer must not be empty")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "service_id",referencedColumnName = "service_id")
    @NotNull(message = "Service must not be empty")
    private ResortService service;

    @OneToMany(mappedBy = "contract")
    private List<ContractDetail> contractDetailList;

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
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

    public Double getContractDeposit() {
        return contractDeposit;
    }

    public void setContractDeposit(Double contractDeposit) {
        this.contractDeposit = contractDeposit;
    }

    public Double getContractTotalMoney() {
        return contractTotalMoney;
    }

    public void setContractTotalMoney(Double contractTotalMoney) {
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

    public List<ContractDetail> getContractDetailList() {
        return contractDetailList;
    }

    public void setContractDetailList(List<ContractDetail> contractDetailList) {
        this.contractDetailList = contractDetailList;
    }

    public double calculateTotalMoney(){
        contractTotalMoney = service.getServiceCost();
        for(ContractDetail contractDetail: contractDetailList){
            contractTotalMoney += contractDetail.getQuantity()* contractDetail.getAttachService().getAttachServiceCost();
        }
        return contractTotalMoney;
    }
}
