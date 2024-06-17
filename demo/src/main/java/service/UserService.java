package service;

import entity.Role;
import entity.User;
import repository.RoleRepository;
import repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;
import java.util.Set;

public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User registerUser(User user, String plainPassword) {
        Role userRole = roleRepository.findByName("ROLE_USER");
        user.setRoles(Set.of(userRole));
        user.setPassword(passwordEncoder.encode(plainPassword));
        return userRepository.save(user);
    }

    public User registerDoctor(User user) {
        Role doctorRole = roleRepository.findByName("ROLE_DOCTOR");
        user.setRoles(Set.of(doctorRole));
        return userRepository.save(user);
    }

    public User registerPatient(User user) {
        Role patientRole = roleRepository.findByName("ROLE_PATIENT");
        user.setRoles(Set.of(patientRole));
        return userRepository.save(user);
    }

    public User findByUsername(String username) {
        Optional<User> optionalUser = userRepository.findByUsername(username);
        return optionalUser.orElse(null);
    }
}
