package common;

import model.bean.customer.Customer;
import model.bean.others.ResultValidation;

import java.util.List;

public class Validation {

    public static ResultValidation validationId(String id,List<Customer> customers) {
        String comment = null;
        boolean isValid = true;

        if (id.equals("")) {
            comment = "Id can not be empty!";
            isValid = false;
        } else if (!id.matches("^KH-\\d{4}$")) {
            comment = "Id must match format KH-XXXX";
            isValid = false;
        } else {
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

    public static ResultValidation validationDay(String date) {
        String comment = null;
        boolean isValid = true;
        if (date.equals("")) {
            comment = "Date can not be empty!";
            isValid = false;
        } else if (!date.matches("^\\d{4}-\\d{2}-\\d{2}$")) {
            comment = "Date must match format dd/MM/yyyyy";
            isValid = false;
        }
        return new ResultValidation(isValid, comment);
    }

    public static ResultValidation validationPhone(String phone) {
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

    public static ResultValidation validationIdCard(String idCard) {
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

    public static ResultValidation validationEmail(String email) {
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

    public static ResultValidation validationSalary(String salary) {
        String comment = null;
        boolean isValid = true;
        if (salary.equals("")) {
            comment = "Input can not be empty!";
            isValid = false;
        } else if (!salary.matches("^[0-9]+(\\.[0-9]+)?$")) {
            comment = "Input must be number & positive\"";
            isValid = false;
        }
        return new ResultValidation(isValid, comment);
    }

}
