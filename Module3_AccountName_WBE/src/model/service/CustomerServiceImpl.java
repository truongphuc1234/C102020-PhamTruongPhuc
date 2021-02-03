package model.service;

import model.bean.customer.Customer;
import model.bean.customer.CustomerType;
import model.bean.others.ResultValidation;
import model.repository.CustomerRepository;
import model.repository.CustomerRepositoryImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository repository = new CustomerRepositoryImpl();

    @Override
    public boolean insert(Customer customer) {
        return repository.insertCustomer(customer);
    }

    @Override
    public boolean delete(int customerId) {
        return repository.deleteCustomer(customerId);
    }

    @Override
    public boolean update(Customer customer) {
        return repository.updateCustomer(customer);
    }

    @Override
    public Customer getCustomerById(String customerId) {
        return repository.getCustomer(customerId);
    }

    @Override
    public List<Customer> getListCustomer() {
        return repository.getListCustomer();
    }

    @Override
    public List<CustomerType> getListCustomerType() {
        return repository.getCustomerType();
    }

    @Override
    public Map<String, ResultValidation> validate(String id, String birthday, String phone, String idCard, String email) {
        Map<String, ResultValidation> result = new HashMap<>();

        result.put("id", validationId(id));
        result.put("birthday", validationBirthday(birthday));
        result.put("phone", validationPhone(phone));
        result.put("id_card", validationIdCard(idCard));
        result.put("email", validationEmail(email));

        boolean totalValidation = result.get("id").isPass() && result.get("birthday").isPass() && result.get("phone").isPass() && result.get("id_card").isPass() && result.get("email").isPass();

        result.put("total", new ResultValidation(totalValidation,null));
        return result;
    }

    private ResultValidation validationId(String id) {
        String comment = null;
        boolean isValid = true;

        if (id.equals("")) {
            comment = "Id can not be empty!";
            isValid = false;
        } else if (!id.matches("^KH-\\d{4}$")) {
            comment = "Id must match format KH-XXXX";
            isValid = false;
        } else {
            List<Customer> customers = repository.getListCustomer();
            for (Customer customer : customers) {
                if (id.equals(customer.getCustomerId())) {
                    comment = "Id is registered";
                    isValid = false;
                    break;
                }
            }
        }
        return new ResultValidation(isValid, comment);
    }

    private ResultValidation validationBirthday(String birthday) {
        String comment = null;
        boolean isValid = true;
        if (birthday.equals("")) {
            comment = "Birthday can not be empty!";
            isValid = false;
        } else if (!birthday.matches("^\\d{4}-\\d{2}-\\d{2}$")) {
            comment = "Birthday must match format dd/MM/yyyyy";
            isValid = false;
        }
        return new ResultValidation(isValid, comment);
    }

    private ResultValidation validationPhone(String phone) {
        String comment = null;
        boolean isValid = true;
        if (phone.equals("")) {
            comment = "Phone number can not be empty!";
            isValid = false;
        } else if (!phone.matches("^(090|091|\\(84\\)\\+90|\\(84\\)\\+91)\\d{7}$")) {
            comment = "Phone number must match format 090/091/(84)+90/(84)+91xxxxxxx";
            isValid = false;
        }
        return new ResultValidation(isValid, comment);
    }

    private ResultValidation validationIdCard(String idCard) {
        String comment = null;
        boolean isValid = true;
        if (idCard.equals("")) {
            comment = "ID card can not be empty!";
            isValid = false;
        } else if (!idCard.matches("^(\\d{3}){3,4}$")) {
            comment = "ID card must match format XXXXXXXXX or XXXXXXXXXXXX";
            isValid = false;
        }
        return new ResultValidation(isValid, comment);
    }

    private ResultValidation validationEmail(String email) {
        String comment = null;
        boolean isValid = true;
        if (email.equals("")) {
            comment = "Email can not be empty!";
            isValid = false;
        } else if (!email.matches("^[A-Za-z0-9]+@[A-Za-z0-9]+\\.[A-Za-z0-9]+$")) {
            comment = "Email must match format abc_@abc.abc\"";
            isValid = false;
        }
        return new ResultValidation(isValid, comment);
    }

}
