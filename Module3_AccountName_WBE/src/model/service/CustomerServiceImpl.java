package model.service;

import common.Validation;
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
    public boolean delete(String customerId) {
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

        result.put("id", Validation.validationId(id,repository.getListCustomer()));
        result.put("birthday", Validation.validationDay(birthday));
        result.put("phone", Validation.validationPhone(phone));
        result.put("id_card", Validation.validationIdCard(idCard));
        result.put("email", Validation.validationEmail(email));

        boolean totalValidation = result.get("id").isPass() && result.get("birthday").isPass() && result.get("phone").isPass() && result.get("id_card").isPass() && result.get("email").isPass();

        result.put("total", new ResultValidation(totalValidation,null));
        return result;
    }



}
