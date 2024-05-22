package javaguides.Exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest req) {
        ErrorDetails details = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), req.getDescription(false), "User Not Found");
        return new ResponseEntity<>(details, HttpStatus.NOT_FOUND);


    }

    @ExceptionHandler(EmailsAlredyExists.class)
    public ResponseEntity<ErrorDetails> emailAlreadyExistException(EmailsAlredyExists ex, WebRequest req) {
        ErrorDetails details = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), req.getDescription(false), "Email already exist");
        return new ResponseEntity<>(details, HttpStatus.BAD_REQUEST);


    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleGlobalException(Exception ex, WebRequest req) {
        ErrorDetails details = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), req.getDescription(false), "Internal Server Exception");
        return new ResponseEntity<>(details, HttpStatus.INTERNAL_SERVER_ERROR);


    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatusCode status,
                                                                  WebRequest request) {
        Map<String ,String> errors = new HashMap<>();
        List<ObjectError> errorList = ex.getBindingResult().getAllErrors();
        errorList.forEach(error -> {String fieldName=((FieldError)error).getField();
        String errorMessage = error.getDefaultMessage();
        errors.put(fieldName, errorMessage);});
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
