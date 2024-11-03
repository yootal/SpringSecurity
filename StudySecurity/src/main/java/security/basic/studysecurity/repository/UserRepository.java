package security.basic.studysecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import security.basic.studysecurity.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByUsername(String username);

    User findByUsername(String username);
}
