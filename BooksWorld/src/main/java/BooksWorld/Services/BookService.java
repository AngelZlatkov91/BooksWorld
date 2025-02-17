package BooksWorld.Services;

import BooksWorld.Models.DTO.BookDetailsDTO;
import BooksWorld.Models.DTO.CreateBookDTO;
import BooksWorld.Models.DTO.MyBooks;

import java.util.List;

public interface BookService {


    void createBook(CreateBookDTO createBookDTO, String name) throws Exception;

    void deleteBook(Long id, String email);

    List<BookDetailsDTO> getAllBooks(String email);

    MyBooks getAllBookByUser(String email);


    void getTheBook(Long id, String name);

}
