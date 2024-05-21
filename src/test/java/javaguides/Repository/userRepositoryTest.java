package javaguides.Repository;

import javaguides.Entity.users;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class userRepositoryTest {
    @Autowired
    private userRepository userRepository;
    @Test
    void saveMethod()
    {
        users user = new users();
        user.setId(1L);
        user.setFirstName("nikky");
        user.setLastName("sam");
        user.setEmail("nikky@gmail.com");
        userRepository.save(user);
    }
    @Test
    void saveAllMethod()
    {
        users user = new users();
        user.setId(2L);
        user.setFirstName("nik");
        user.setLastName("sam");
        user.setEmail("nikk@gmail.com");
        users user2 = new users();
        user2.setId(3L);
        user2.setFirstName("neha");
        user2.setLastName("sam");
        user2.setEmail("neha@gmail.com");
        userRepository.saveAll(List.of(user, user2));
    }
}