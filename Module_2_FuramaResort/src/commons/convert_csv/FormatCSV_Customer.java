package commons.convert_csv;


import models.Customer;

public class FormatCSV_Customer implements FormatCSV<Customer> {

    public static final String HEADER = "name,birthday,gender,identity,phoneNumber,email,customerType,address,serviceID";

    @Override
    public String getHeader() {
        return HEADER;
    }

    @Override
    public String convertToStringCSV(Customer customer) {
        return customer.getName() + COMMA_DELIMITER +
                customer.getBirthday() + COMMA_DELIMITER +
                customer.getGender() + COMMA_DELIMITER +
                customer.getIdentity() + COMMA_DELIMITER +
                customer.getPhoneNumber() + COMMA_DELIMITER +
                customer.getEmail() + COMMA_DELIMITER +
                customer.getCustomerType() + COMMA_DELIMITER +
                customer.getAddress() + COMMA_DELIMITER;
    }

    @Override
    public Customer getObjectByStringCSV(String string) {
        String[] stringArray = string.split(",");
        return new Customer(stringArray[0],
                stringArray[1],
                stringArray[2],
                stringArray[3],
                stringArray[4],
                stringArray[5],
                stringArray[6],
                stringArray[7]);
    }
}
