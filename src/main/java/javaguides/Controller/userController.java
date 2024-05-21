package javaguides.Controller;

import javaguides.Entity.users;
import javaguides.Services.userServiceImpl;
import javaguides.UserDto.UserDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "api/users")
public class userController {
    private userServiceImpl  service;

    @PostMapping()
    public ResponseEntity<UserDto> createUsers(@RequestBody UserDto user) {
        UserDto usaveuser= service.createUser( user);
        return new ResponseEntity<>(usaveuser , HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<UserDto> getById(@PathVariable int id) {
        UserDto user = service.getUserById((long) id);
        return new ResponseEntity<>(user , HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> users = service.getAllUsers();
        return new ResponseEntity<>(users , HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable int id, @RequestBody UserDto user) {
        UserDto newUser = service.updateUser(user);
        // users users = service.getUserById((long) id);
        return new ResponseEntity<>(newUser , HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id) {

        service.deleteUser((long) id);
        return new ResponseEntity<>("user deleted Sucessfully" , HttpStatus.OK);
    }
}
