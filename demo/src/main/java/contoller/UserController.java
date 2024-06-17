package contoller;

import entity.User;
import service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("http://26.231.69.157:8080/api")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("http://26.231.69.157:8080/api/register")
    public ResponseEntity<User> registerUser(@RequestBody User user, @RequestParam String role) {
        User registeredUser = null;
        if ("ROLE_DOCTOR".equals(role)) {
            registeredUser = userService.registerDoctor(user);
        } else if ("ROLE_PATIENT".equals(role)) {
            registeredUser = userService.registerPatient(user);
        }
        return new ResponseEntity<>(registeredUser, HttpStatus.CREATED);
    }


    @PostMapping("http://26.231.69.157:8080/api/login")
    public ResponseEntity<User> loginUser(@RequestBody User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        User foundUser = userService.findByUsername(username);
        if (foundUser != null && password.equals(foundUser.getPassword())) {
            return new ResponseEntity<>(foundUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
}

