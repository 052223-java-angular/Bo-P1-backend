package com.revature.flashpoints.services;
import com.revature.flashpoints.dtos.responses.Principal;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import com.revature.flashpoints.entities.User;
import com.revature.flashpoints.dtos.requests.NewUserRequest;
import com.revature.flashpoints.dtos.requests.NewLoginRequest;
import com.revature.flashpoints.entities.Role;
import com.revature.flashpoints.repositories.UserRepository;
import com.revature.flashpoints.utils.custom_exceptions.UserNotFoundException;


import java.util.Optional;
import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class UserService {
    private final RoleService roleService;
    private final UserRepository userRepository;

    public User registerUser(NewUserRequest req) {
        Role foundRole = roleService.findByName("WRITER");

        String hashed = BCrypt.hashpw(req.getPassword(), BCrypt.gensalt());

        User newUser = new User(req.getUsername(), hashed, foundRole, req.getFirstName(),
        req.getLastName(), req.getEmail());

        return userRepository.save(newUser);
    }


    public Principal login(NewLoginRequest req) {
        Optional<User> userOpt = userRepository.findByUsername(req.getUsername());
        if (userOpt.isPresent()) {
            User foundUser = userOpt.get();
            if (BCrypt.checkpw(req.getPassword(), foundUser.getPassword())) {
                return new Principal(foundUser);
            }
        }
        throw new UserNotFoundException("Invalid creditial");
    }

    public boolean isValidUsername(String username) {
        return username.matches("^(?=[a-zA-Z0-9._]{8,20}$)(?!.*[_.]{2})[^_.].*[^_.]$");
    }

    public boolean isUniqueUsername(String username) {
        Optional<User> userOpt = userRepository.findByUsername(username);
        return userOpt.isEmpty();
    }

    public boolean isValidPassword(String password) {
        return password.matches(("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$"));
    }

    public boolean isSamePassword(String password, String confirmPassword) {
        return password.equals(confirmPassword);
    }

    public boolean isValidEmail(String email) {
        return email.equals("^(.+)@(.+)$");
    }

    // public Optional<User> findById(String id) {
    //     Optional<User> userOpt = userRepository.findById(id);
    // }
}

