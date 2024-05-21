package javaguides.Repository;

import javaguides.Entity.users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface userRepository extends JpaRepository<users, Long> {

    Optional<users> findByEmail(String email);
}
