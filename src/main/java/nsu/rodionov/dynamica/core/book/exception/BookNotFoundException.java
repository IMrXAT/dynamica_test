package nsu.rodionov.dynamica.core.book.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class BookNotFoundException extends RuntimeException {
    private String message;
    private HttpStatus status;

    public BookNotFoundException(String message) {
        super();
        this.message = message;
        this.status = HttpStatus.NOT_FOUND;
    }
}
