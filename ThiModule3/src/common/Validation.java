package common;

import model.bean.ResultValidation;

public class Validation {

    public static ResultValidation validationName(String name) {
        String comment = null;
        boolean isValid = true;
        if (name.equals("")) {
            comment = "Name can not be empty!";
            isValid = false;
        }
        return new ResultValidation(isValid, comment);
    }

    public static ResultValidation validationPrice(int price) {
        String comment = null;
        boolean isValid = true;
        if (price > 100) {
            comment = "Price must large than 100!";
            isValid = false;
        }
        return new ResultValidation(isValid, comment);
    }

    public static ResultValidation validationDiscount(int price) {
        String comment = null;
        boolean isValid = true;
        if (price != 5 && price != 10 && price != 15 && price != 20) {
            comment = "Discount must be 5, 10 , 15, 20!";
            isValid = false;
        }
        return new ResultValidation(isValid, comment);
    }


    public static ResultValidation validationStock(int stock) {
        String comment = null;
        boolean isValid = true;
        if (stock > 10) {
            comment = "Stock must large than 10!";
            isValid = false;
        }
        return new ResultValidation(isValid, comment);
    }
}
