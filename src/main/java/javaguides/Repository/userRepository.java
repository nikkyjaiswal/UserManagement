package javaguides.Repository;

import javaguides.Entity.users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepository extends JpaRepository<users, Long> {
}
