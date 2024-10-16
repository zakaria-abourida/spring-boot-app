package com.app.app.service;

import com.app.app.model.User;
import com.app.app.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(BCryptPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    // @Autowired
    // private BCryptPasswordEncoder passwordEncoder; // Inject the
    // BCryptPasswordEncoder bean

    /**
     * Méthode pour valider les informations de connexion.
     * 
     * @param username Nom d'utilisateur
     * @param password Mot de passe
     * @return true si les informations sont correctes, sinon false
     */
    public boolean authenticateUser(String username, String password) {
        Optional<User> user = userRepository.findByUsername(username);
        // if (user.isPresent()) {
        // // Use BCryptPasswordEncoder to verify the hashed password
        // return passwordEncoder.matches(password, user.get().getPassword());
        // }
        return false;
    }

    public List<User> getUsers() {

        return userRepository.findAll();
    }

    public User addUser(User user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRepository.save(user);
    }

    public User updateUser(Long id, User updatedUser) {
        // Find the existing user by ID
        Optional<User> existingUserOptional = userRepository.findById(id);

        if (existingUserOptional.isPresent()) {
            User existingUser = existingUserOptional.get();

            // Update the fields as needed
            existingUser.setUsername(updatedUser.getUsername());
            existingUser.setPassword(updatedUser.getPassword());
            existingUser.setEmail(updatedUser.getEmail());

            // Save the updated user
            return userRepository.save(existingUser);
        } else {
            throw new RuntimeException("User not found with id: " + id);
        }
    }
}
