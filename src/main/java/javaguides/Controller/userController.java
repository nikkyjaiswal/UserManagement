package javaguides.Controller;

import jakarta.validation.Valid;
import javaguides.Entity.users;
import javaguides.Exception.ErrorDetails;
import javaguides.Exception.ResourceNotFoundException;
import javaguides.Services.userServiceImpl;
import javaguides.UserDto.UserDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "api/users")
public class userController {
    private userServiceImpl service;

    @PostMapping()
    public ResponseEntity<UserDto> createUsers(@RequestBody @Valid UserDto user) {
        UserDto usaveuser = service.createUser(user);
        return new ResponseEntity<>(usaveuser, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<UserDto> getById(@PathVariable int id) {
        UserDto user = service.getUserById((long) id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> users = service.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable int id, @RequestBody @Valid UserDto user) {
        UserDto newUser = service.updateUser(user);
        // users users = service.getUserById((long) id);
        return new ResponseEntity<>(newUser, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id) {

        service.deleteUser((long) id);
        return new ResponseEntity<>("user deleted Sucessfully", HttpStatus.OK);
    }
//    @ExceptionHandler(ResourceNotFoundException.class)
//    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest req) {
//    ErrorDetails details = new ErrorDetails(
//            LocalDateTime.now(),
//            ex.getMessage(),
//            req.getDescription(false),
//            "User Not Found"
//    );
//    return new ResponseEntity<>(details, HttpStatus.NOT_FOUND);
//
//
//    }
}
