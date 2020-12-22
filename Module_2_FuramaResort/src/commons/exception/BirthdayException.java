package commons.exception;

public class BirthdayException extends Exception {
    public BirthdayException() {
        super("Birthday must after 1900 with format \"dd/mm/yyyy\" and customer age must large than 18 year old");
    }
}
