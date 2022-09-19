package ch.zli.coworking_space.exception;

public class ObjectNotFoundException extends RuntimeException {
    public ObjectNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
