package commons.exception;

public class IDCardException extends Exception {
    public IDCardException() {
        super("ID card must be 9 digits with format \"XXX XXX XXX\"");
    }
}
