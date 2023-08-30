package md.cedacri;

public class NotAllowedCharactersException extends RuntimeException{
    public NotAllowedCharactersException(String message) {
        super(message);
    }
}
