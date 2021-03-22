package spring.furama.annotation;

import spring.furama.validator.UniqueEmailCustomerValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UniqueEmailCustomerValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueEmailCustomer {
    String message() default "Email is existed";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
