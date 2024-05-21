package javaguides.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest req) {
        ErrorDetails details = new ErrorDetails(
                LocalDateTime.now(),
                ex.getMessage(),
                req.getDescription(false),
                "User Not Found"
        );
        return new ResponseEntity<>(details, HttpStatus.NOT_FOUND);


    }

        @ExceptionHandler(EmailsAlredyExists.class)
        public ResponseEntity<ErrorDetails> emailAlreadyExistException(EmailsAlredyExists ex, WebRequest req) {
            ErrorDetails details = new ErrorDetails(
                    LocalDateTime.now(),
                    ex.getMessage(),
                    req.getDescription(false),
                    "Email already exist"
            );
            return new ResponseEntity<>(details, HttpStatus.BAD_REQUEST);


        }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleGlobalException(Exception ex, WebRequest req) {
        ErrorDetails details = new ErrorDetails(
                LocalDateTime.now(),
                ex.getMessage(),
                req.getDescription(false),
                "Internal Server Exception"
        );
        return new ResponseEntity<>(details, HttpStatus.INTERNAL_SERVER_ERROR);


    }
}
