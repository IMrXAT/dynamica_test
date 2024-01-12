package nsu.rodionov.dynamica.core.client.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ClientNotFoundException extends RuntimeException{
    private String message;
    private HttpStatus status;

    public ClientNotFoundException(String message) {
        super();
        this.message = message;
        this.status = HttpStatus.NOT_FOUND;
    }
}
