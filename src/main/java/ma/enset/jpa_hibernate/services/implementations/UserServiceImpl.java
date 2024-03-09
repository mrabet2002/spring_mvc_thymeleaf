package ma.enset.jpa_hibernate.services.implementations;

import lombok.RequiredArgsConstructor;
import ma.enset.jpa_hibernate.entities.Role;
import ma.enset.jpa_hibernate.entities.User;
import ma.enset.jpa_hibernate.enums.RoleName;
import ma.enset.jpa_hibernate.repos.RoleRepository;
import ma.enset.jpa_hibernate.repos.UserRepository;
import ma.enset.jpa_hibernate.services.interfaces.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    public User addUser(User user) {
        userExists(user.getUsername());

        return userRepository.save(user);
    }

    private void userExists(String username) {
        if (userRepository.existsByUsername(username)) {
            throw new RuntimeException("User already exists");
        }
    }

    @Override
    public Role addRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        User user = findUserByUsername(username);
        Role role = findRoleByRoleName(RoleName.valueOf(roleName));

        user.getRoles().add(role);
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public Role findRoleByRoleName(RoleName roleName) {
        return roleRepository.findByRoleName(roleName).orElseThrow(() -> new RuntimeException("Role not found"));
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }
}