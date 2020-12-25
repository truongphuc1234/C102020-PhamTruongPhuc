package commons.validation_data;

import commons.exception.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ValidationCustomer {
    public String validateName(String input) throws NameException {
        boolean isValid = input.matches("^([AÀẢÃÁẠĂẰẲẴẮẶÂẦẨẪẤẬBCDĐEÈẺẼÉẸÊỀỂỄẾỆFGHIÌỈĨÍỊJKLMNOÒỎÕÓỌÔỒỔỖỐỘƠỜỞỠỚỢPQRSTUÙỦŨÚỤƯỪỬỮỨỰVWXYỲỶỸÝỴZ]" +
                "[aAàÀảẢãÃáÁạẠăĂằẰẳẲẵẴắẮặẶâÂầẦẩẨẫẪấẤậẬbBcCdDđĐeEèÈẻẺẽẼéÉẹẸêÊềỀểỂễỄếẾệỆfFgGhHiIìÌỉỈĩĨíÍịỊjJkKlLmMnNoOòÒỏỎõÕóÓọỌôÔồỒổỔỗỖốỐộỘơƠờỜởỞỡỠớỚợỢpPqQrRsStTuUùÙủỦũŨúÚụỤưƯừỪửỬữỮứỨựỰvVwWxXyYỳỲỷỶỹỸýÝỵỴzZ]* )*" +
                "[AÀẢÃÁẠĂẰẲẴẮẶÂẦẨẪẤẬBCDĐEÈẺẼÉẸÊỀỂỄẾỆFGHIÌỈĨÍỊJKLMNOÒỎÕÓỌÔỒỔỖỐỘƠỜỞỠỚỢPQRSTUÙỦŨÚỤƯỪỬỮỨỰVWXYỲỶỸÝỴZ]" +
                "[aAàÀảẢãÃáÁạẠăĂằẰẳẲẵẴắẮặẶâÂầẦẩẨẫẪấẤậẬbBcCdDđĐeEèÈẻẺẽẼéÉẹẸêÊềỀểỂễỄếẾệỆfFgGhHiIìÌỉỈĩĨíÍịỊjJkKlLmMnNoOòÒỏỎõÕóÓọỌôÔồỒổỔỗỖốỐộỘơƠờỜởỞỡỠớỚợỢpPqQrRsStTuUùÙủỦũŨúÚụỤưƯừỪửỬữỮứỨựỰvVwWxXyYỳỲỷỶỹỸýÝỵỴzZ]*$");
        if (isValid)
            return input;
        throw new NameException();
    }

    public String validateID(String input) throws IDCardException {
        boolean isValid = input.matches("^(\\d{3} ){2}\\d{3}");
        if (!isValid)
            throw new IDCardException();
        return input;
    }

    public String validateBirthday(String input) throws BirthdayException {
        boolean isValid;
        if (!input.matches("^\\d{2}/\\d{2}/\\d{4}$")) {
            isValid = false;
        } else {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate birthdayDate = LocalDate.parse(input, formatter);
            LocalDate now = LocalDate.now();
            isValid = now.isAfter(birthdayDate.plusYears(18)) && birthdayDate.getYear() > 1900;
        }
        if (isValid)
            return input;
        throw new BirthdayException();
    }

    public String validateGender(String input) throws GenderException {
        input = input.toLowerCase();
        boolean isValid = input.equals("unknown") || input.equals("male") || input.equals("female");
        if (isValid)
            return input.substring(0, 1).toUpperCase() + input.substring(1);
        throw new GenderException();
    }

    public String validateEmail(String input) throws EmailException {
        boolean isValid = input.matches("^[A-Za-z0-9]+@[A-Za-z0-9]+\\.[A-Za-z0-9]+$");
        if (isValid)
            return input;
        throw new EmailException();
    }

    public String validateCustomerType(String input) throws InvalidInputException {
        input = input.toLowerCase();
        boolean inValid = input.equals("diamond") || input.equals("platinum") || input.equals("gold") || input.equals("silver") || input.equals("member");
        if (inValid)
            return input.substring(0, 1).toUpperCase() + input.substring(1);
        throw new InvalidInputException("Customer type must be following value : Diamod / Platinum / Gold / Silver / Member");
    }
}


