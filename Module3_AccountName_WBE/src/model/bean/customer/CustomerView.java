package model.bean.customer;

public class CustomerView extends Customer {
    private String customerTypeName;

    public CustomerView() {
    }

    public CustomerView(String customerId, int customerTypeId, String customerName, String customerBirthday, boolean customerGender, String customerIdCard, String customerPhone, String customerEmail, String customerAddress, String customerTypeName) {
        super(customerId, customerTypeId, customerName, customerBirthday, customerGender, customerIdCard, customerPhone, customerEmail, customerAddress);
        this.customerTypeName = customerTypeName;
    }

    public String getCustomerTypeName() {
        return customerTypeName;
    }

    public void setCustomerTypeName(String customerTypeName) {
        this.customerTypeName = customerTypeName;
    }
}
