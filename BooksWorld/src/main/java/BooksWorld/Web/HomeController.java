package BooksWorld.Web;

import BooksWorld.Models.DTO.LoginResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class HomeController {



    @GetMapping("/api/home")
    public ResponseEntity<LoginResponseDTO> home (Principal principal) {
        System.out.println();

        return ResponseEntity.ok(new LoginResponseDTO("Hallo", principal.getName()));
    }

    @PreAuthorize("hasAuthority('SCOPE_read')")
    @GetMapping("secure")
    public String secure()
    {return  "This is secured!";}
}
