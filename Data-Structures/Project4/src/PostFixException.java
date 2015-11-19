/**
 * PostFixException
 * @author Chelsea
 * @since 11/3/2015
 *
 * The class that represents the exception that is thrown when errors in the
 * math expression occur
 */
public class PostFixException extends Exception {
    public PostFixException() {
        super();
    }

    public PostFixException(String message) {
        super(message);
    }
}
