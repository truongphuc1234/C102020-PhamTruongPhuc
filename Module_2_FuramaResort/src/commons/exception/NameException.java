package commons.exception;

public class NameException extends Exception{
    public NameException() {
        super("Customer name must be CAPITALIZED");
    }

}
