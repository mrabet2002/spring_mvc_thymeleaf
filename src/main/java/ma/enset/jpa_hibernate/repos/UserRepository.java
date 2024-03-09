package ma.enset.jpa_hibernate.repos;

import ma.enset.jpa_hibernate.entities.User;
import ma.enset.jpa_hibernate.enums.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByUsername(String username);

    Optional<User> findByUsername(String username);

    Optional<Object> findByRoles_RoleName(RoleName roleName);
}
