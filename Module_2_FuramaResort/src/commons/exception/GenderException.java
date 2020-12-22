package commons.exception;

public class GenderException extends Exception{
    public GenderException() {
        super("Gender must be \"male\", \"unknown\", \"female\"");
    }

}
