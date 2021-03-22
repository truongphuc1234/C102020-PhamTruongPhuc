package spring.furama.validator;

import org.springframework.beans.factory.annotation.Autowired;
import spring.furama.annotation.UniqueEmailCustomer;
import spring.furama.repository.CustomerRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueEmailCustomerValidator implements ConstraintValidator<UniqueEmailCustomer, String> {

    private CustomerRepository customerRepository;

    @Autowired
    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        if (email == null || email.equals(""))
            return true;
        return !customerRepository.existsByCustomerEmail(email);
    }
}
