package javaguides.Controller;

import javaguides.Entity.users;
import javaguides.Services.userServiceImpl;
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
    public ResponseEntity<users> createUsers(@RequestBody users user) {
        users usaveuser= service.createUser( user);
        return new ResponseEntity<>(usaveuser , HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<users> getById(@PathVariable int id) {
        users user = service.getUserById((long) id);
        return new ResponseEntity<>(user , HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<users>> getAllUsers() {
        List<users> users = service.getAllUsers();
        return new ResponseEntity<>(users , HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<users> updateUser(@PathVariable int id, @RequestBody users user) {
        users newUser = service.updateUser(user);
        // users users = service.getUserById((long) id);
        return new ResponseEntity<>(newUser , HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id) {

        service.deleteUser((long) id);
        return new ResponseEntity<>("user deleted Sucessfully" , HttpStatus.OK);
    }
}
