package ma.enset.jpa_hibernate.services.interfaces;

import ma.enset.jpa_hibernate.entities.Role;
import ma.enset.jpa_hibernate.entities.User;
import ma.enset.jpa_hibernate.enums.RoleName;

import java.util.List;

public interface IUserService {
    User addUser(User user);

    Role addRole(Role role);

    void addRoleToUser(String username, String roleName);

    User findUserByUsername(String username);

    Role findRoleByRoleName(RoleName roleName);

    List<User> getUsers();
}