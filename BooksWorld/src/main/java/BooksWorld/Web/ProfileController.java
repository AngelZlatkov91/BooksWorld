package BooksWorld.Web;

import BooksWorld.Models.DTO.BookDetailsDTO;
import BooksWorld.Models.DTO.MyBooks;
import BooksWorld.Services.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class ProfileController {

    private final BookService bookService;

    public ProfileController(BookService bookService) {
        this.bookService = bookService;
    }


    @GetMapping("profile")
    public ResponseEntity<MyBooks> profile (Principal principal) {
        MyBooks allBookByUser = bookService.getAllBookByUser(principal.getName());
        return ResponseEntity.ok(allBookByUser);
    }

    @DeleteMapping("book/{id}")
    public ResponseEntity<BookDetailsDTO> deleteBookByID(@PathVariable("id") Long id, Principal principal) {

        bookService.deleteBook(id, principal.getName());

        return ResponseEntity
                .noContent()
                .build();
    }


}
