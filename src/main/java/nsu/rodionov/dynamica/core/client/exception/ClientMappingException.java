package nsu.rodionov.dynamica.core.client.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ClientMappingException extends RuntimeException {
    private final String message;
    private final HttpStatus status;

    public ClientMappingException(String message) {
        super();
        this.message = message;
        this.status = HttpStatus.BAD_REQUEST;
    }
}
