/** Checked — unknown or invalid account id. */
public class InvalidAccountException extends Exception {
    
    public InvalidAccountException(String id) {
        super("Unknown or invalid account id: " + id);
    }
}