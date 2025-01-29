package BooksWorld.Web;

import BooksWorld.Models.DTO.CreateBookDTO;
import BooksWorld.Services.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/books")
public class ActionsController {


    private final BookService bookService;

    public ActionsController(BookService bookService) {
        this.bookService = bookService;
    }


    @PostMapping()
    public ResponseEntity<String> create(@RequestBody CreateBookDTO createBookDTO) {

        bookService.createBook(createBookDTO);
        return null;
    }


}
