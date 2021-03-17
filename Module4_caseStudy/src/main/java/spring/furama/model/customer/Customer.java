package spring.furama.model.customer;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @Column(name = "customer_id", nullable = false)
    @Pattern(regexp = "^KH-\\d{4}$",message = "Customer ID must be format 'KH-XXXX'(X is number)")
    @NotNull(message = "Customer id must be not empty")
    private String customerId;

    @ManyToOne
    @JoinColumn(name = "customer_type_id",referencedColumnName = "customer_type_id", nullable = false)
    @NotNull(message = "Customer type must be not empty")
    private CustomerType customerType;

    @Column(name = "customer_name", nullable = false, length = 45)
    @NotBlank(message = "Name must be not empty")
    @Size(max = 45)
    private String customerName;

    @Column(name = "customer_birthday",nullable = false)
    @Pattern(regexp = "^(19|20)\\d{2}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$",message = "Date must be format YYYY-MM-DD")
    @NotNull(message = "Date must be not empty")
    private String customerBirthday;

    @Column(name = "customer_gender",nullable = false)
    @NotNull(message = "Gender must be not empty")
    private Boolean customerGender;

    @Column(name = "customer_id_card",nullable = false)
    @Pattern(regexp = "^\\d{9,12}$", message = "Id card must be format 'XXXXXXXXX' or 'XXXXXXXXXXXX'(X is number)")
    @NotNull(message = "Id card must be not empty")
    private String customerIdCard;

    @Column(name = "customer_phone",nullable = false)
    @Pattern(regexp = "^(090|091|\\(84\\)\\+90|\\(84\\)\\+91)\\d{7}$",message = "Phone number must format 090xxxxxxx or 091xxxxxxx or (84)+90xxxxxxx or (84)+91xxxxxxx")
    @NotNull(message = "Phone number must be not empty")
    private String customerPhone;

    @Column(name = "customer_email")
    @Email(message = "Email must be format abc@xyz.abc")
    private String customerEmail;

    @Column(name = "customer_address")
    private String customerAddress;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerBirthday() {
        return customerBirthday;
    }

    public void setCustomerBirthday(String customerBirthday) {
        this.customerBirthday = customerBirthday;
    }

    public String getCustomerIdCard() {
        return customerIdCard;
    }

    public void setCustomerIdCard(String customerIdCard) {
        this.customerIdCard = customerIdCard;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public Boolean getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(Boolean customerGender) {
        this.customerGender = customerGender;
    }
}
