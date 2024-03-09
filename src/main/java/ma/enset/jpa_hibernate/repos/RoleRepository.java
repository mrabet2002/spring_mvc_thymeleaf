package ma.enset.jpa_hibernate.repos;

import ma.enset.jpa_hibernate.entities.Role;
import ma.enset.jpa_hibernate.entities.User;
import ma.enset.jpa_hibernate.enums.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRoleName(RoleName roleName);
}
