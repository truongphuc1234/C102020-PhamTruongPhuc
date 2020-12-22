package commons.exception;

public class EmailException extends Exception{
    public EmailException() {
        super("Email format must be \"abc@abc.abc\"");
    }

}
