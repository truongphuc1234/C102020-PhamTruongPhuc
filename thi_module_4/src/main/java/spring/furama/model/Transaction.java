package spring.furama.model;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @Pattern(regexp = "^MGD-\\d{4}$", message = "Mã giao dịch không chính xác")
    private String transactionId;

    @ManyToOne
    @JoinColumn(referencedColumnName = "customerId")
    private Customer customer;
    @Pattern(regexp = "^(19|20)\\d{2}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$",message = "Sai dinh dang ngay")
    private String transactionDate;
    private String serviceType;
    @DecimalMin(value = "500000", message = "Đơn giá phải lớn hơn 500.000")
    private double price;
    @DecimalMin(value = "20", message = "Diện tích phải lớn hơn 20")
    private double area;

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }
}
