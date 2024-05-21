package javaguides.Services;

import javaguides.Entity.users;
import javaguides.Repository.userRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class userServiceImpl {
    private userRepository userRepository;


    public users createUser(users user) {
        return userRepository.save(user);
    }

    public users getUserById(Long id) {
        Optional<users> user = userRepository.findById(id);
        return user.orElse(null);

    }

    public List<users> getAllUsers() {
        List<users> users = userRepository.findAll();
        return users;
    }


    public users updateUser( users user) {
        users existingUser = userRepository.findById(user.getId()).get();
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        users updateduser =userRepository.save(existingUser);
        return updateduser;
    }

    public void deleteUser(Long id) {
    userRepository.deleteById(id);

    }
}
