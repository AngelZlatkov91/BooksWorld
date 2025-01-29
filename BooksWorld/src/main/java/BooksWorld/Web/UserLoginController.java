package BooksWorld.Web;


import BooksWorld.Models.DTO.LoginResponseDTO;
import BooksWorld.Models.DTO.LoginUserDTO;
import BooksWorld.Services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/login")
public class UserLoginController {

    private final UserService userService;

    public UserLoginController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginUserDTO loginUserDTO) {

        try {
            String token = userService.login(loginUserDTO);
            return ResponseEntity.ok
                    (new LoginResponseDTO("Login successful", token));
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body(new LoginResponseDTO(e.getMessage(), null));
        }

    }
}
