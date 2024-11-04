package security.oauth.jwt.studysecurityoauthjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import security.oauth.jwt.studysecurityoauthjwt.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByUsername(String username);
}
