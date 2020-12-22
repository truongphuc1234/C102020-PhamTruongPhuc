package models;

public class Customer {
    private String name;
    private String birthday;
    private String gender;
    private String identity;
    private String phoneNumber;
    private String email;
    private String customerType;
    private String address;

    public Customer(String name, String birthday, String gender, String identity, String phoneNumber, String email, String customerType, String address) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.identity = identity;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.customerType = customerType;
        this.address = address;
    }

    public Customer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public void showInfo() {
        System.out.println("Customer: " +
                "\n1.\tFull Name: " + name +
                "\n2.\tBirthday: " + birthday +
                "\n3.\tGender: " + gender +
                "\n4.\tIdentity: " + identity +
                "\n5.\tPhone Number: " + phoneNumber +
                "\n6.\tEmail: " + email +
                "\n7.\tCustomer Type: " + customerType +
                "\n8.\tAddress: " + address);
    }
}
