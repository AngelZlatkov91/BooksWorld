package BooksWorld.Services;

import BooksWorld.Models.DTO.BookDetailsDTO;
import BooksWorld.Models.DTO.CreateBookDTO;

import java.util.List;

public interface BookService {


    void createBook(CreateBookDTO createBookDTO, String name) throws Exception;

    void deleteBook(String name);

    List<BookDetailsDTO> getAllBooks();

    List<BookDetailsDTO> getAllBookByUser(String email);


}
