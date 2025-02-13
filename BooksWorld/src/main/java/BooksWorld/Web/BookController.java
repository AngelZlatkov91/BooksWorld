package BooksWorld.Web;

import BooksWorld.Models.DTO.BookDetailsDTO;
import BooksWorld.Models.DTO.CreateBookDTO;
import BooksWorld.Services.BookService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @PostMapping("create")
    public ResponseEntity<String> createBook(Principal principal, @RequestBody @Valid CreateBookDTO createBookDTO, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            String defaultMessage = allErrors.get(0).getDefaultMessage();
            return ResponseEntity.badRequest().body(defaultMessage);
        }
        try {
            bookService.createBook(createBookDTO,principal.getName());
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Create book failed: " + e.getMessage());

        }



    }
}
