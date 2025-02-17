package BooksWorld.Web;

import BooksWorld.Models.DTO.BookDetailsDTO;
import BooksWorld.Models.DTO.LoginResponseDTO;
import BooksWorld.Services.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class HomeController {
    private final BookService bookService;

    public HomeController(BookService bookService) {
        this.bookService = bookService;
    }


    @GetMapping("home")
    public ResponseEntity<List<BookDetailsDTO>> home (Principal principal) {
        List<BookDetailsDTO> allBooks =
                bookService.getAllBooks(principal.getName());

        return ResponseEntity.ok(allBooks);
    }

    @GetMapping("take/{id}")
    public ResponseEntity<String> getBook (@PathVariable Long id, Principal principal) {
        bookService.getTheBook(id, principal.getName());

        return ResponseEntity.ok("The book is Add to your list!");
    }





    @PreAuthorize("hasAuthority('SCOPE_read')")
    @GetMapping("secure")
    public String secure()
    {return  "This is secured!";}
}
