package marcozagaria.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String messaggio) {
        super(messaggio);
    }
}
