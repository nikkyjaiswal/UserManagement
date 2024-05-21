package javaguides.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_REQUEST)
public class EmailsAlredyExists extends RuntimeException{

    private String message;
    public EmailsAlredyExists(String message) {
        super(message);
    }
}
