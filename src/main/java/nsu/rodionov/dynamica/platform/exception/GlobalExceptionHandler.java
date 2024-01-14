package nsu.rodionov.dynamica.platform.exception;

import nsu.rodionov.dynamica.core.book.exception.BookMappingException;
import nsu.rodionov.dynamica.core.book.exception.BookNotFoundException;
import nsu.rodionov.dynamica.core.client.exception.ClientMappingException;
import nsu.rodionov.dynamica.core.client.exception.ClientNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BookNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<String> handleBookNotFoundException(BookNotFoundException exception){
        return new ResponseEntity<>(exception.getMessage(), exception.getStatus());
    }
    @ExceptionHandler(BookMappingException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleBookMappingException(BookMappingException exception){
        return new ResponseEntity<>(exception.getMessage(), exception.getStatus());
    }
    @ExceptionHandler(ClientNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<String> handleClientNotFoundException(ClientNotFoundException exception){
        return new ResponseEntity<>(exception.getMessage(), exception.getStatus());
    }
    @ExceptionHandler(ClientMappingException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleClientMappingException(ClientMappingException exception){
        return new ResponseEntity<>(exception.getMessage(), exception.getStatus());
    }


}
