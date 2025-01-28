package BooksWorld.Web;

import BooksWorld.Models.DTO.UserRegistrationDTO;
import BooksWorld.Services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user/register")
public class RegisterController {


    private final UserService userService;

    public RegisterController(UserService userService){
        this.userService = userService;
    }


    @PostMapping
    public ResponseEntity<String> registerUser(@RequestBody  UserRegistrationDTO userRegistrationDTO) {
     try {
         userService.registerUser(userRegistrationDTO);
         return ResponseEntity.ok("User registered successfully!");
     } catch (Exception e) {
         return ResponseEntity.badRequest().body("Registration failed: " + e.getMessage());
     }

    }

}
