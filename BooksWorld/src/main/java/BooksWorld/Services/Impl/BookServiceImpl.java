package BooksWorld.Services.Impl;

import BooksWorld.Models.DTO.BookDetailsDTO;
import BooksWorld.Models.DTO.CreateBookDTO;
import BooksWorld.Repositories.BookRepository;
import BooksWorld.Services.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void createBook(CreateBookDTO createBookDTO) {

    }

    @Override
    public void deleteBook(String name) {

    }

    @Override
    public List<BookDetailsDTO> getAllBooks() {
        return null;
    }

    @Override
    public List<BookDetailsDTO> getAllBookByUser(String email) {
        return null;
    }
}
