package BooksWorld.Web;

import BooksWorld.Models.DTO.UserRegistrationDTO;
import BooksWorld.Services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@RestController
@RequestMapping("/api/register")
public class RegisterController {


    private final UserService userService;

    public RegisterController(UserService userService){
        this.userService = userService;
    }


    @PostMapping
    public ResponseEntity<String> registerUser(@RequestBody  @Valid UserRegistrationDTO userRegistrationDTO ,
                                               BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            String defaultMessage = allErrors.get(0).getDefaultMessage();

            return ResponseEntity.badRequest().body(defaultMessage);
        }
     try {
         userService.registerUser(userRegistrationDTO);
         return ResponseEntity.ok().build();
     } catch (Exception e) {
         return ResponseEntity.badRequest().body("Registration failed: " + e.getMessage());
     }

    }

}
