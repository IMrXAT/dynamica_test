package nsu.rodionov.dynamica.core.book.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class BookMappingException extends RuntimeException {
    private final String message;
    private final HttpStatus status;

    public BookMappingException(String message) {
        super();
        this.message = message;
        this.status = HttpStatus.BAD_REQUEST;
    }
}
