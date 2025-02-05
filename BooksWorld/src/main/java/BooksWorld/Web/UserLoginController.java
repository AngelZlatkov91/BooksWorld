package BooksWorld.Web;


import BooksWorld.Models.DTO.LoginResponseDTO;
import BooksWorld.Models.DTO.LoginUserDTO;
import BooksWorld.Services.TokenService;
import BooksWorld.Services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/login")
public class UserLoginController {

    private final UserService userService;
    private final TokenService tokenService;
    private final AuthenticationManager authenticationManager;

    public UserLoginController(UserService userService, TokenService tokenService, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.tokenService = tokenService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginUserDTO loginUserDTO) {

        try {
            Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUserDTO.getEmail(), loginUserDTO.getPassword()));
            String token = tokenService.generateToken(authenticate);
            return ResponseEntity.ok
                    (new LoginResponseDTO("Login successful", token));
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body(new LoginResponseDTO(e.getMessage(), null));
        }

    }
}
