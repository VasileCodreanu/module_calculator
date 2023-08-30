package md.cedacri;

public class ParenthesesNotBalancedException extends RuntimeException{
    public ParenthesesNotBalancedException(String message) {
        super(message);
    }
}
