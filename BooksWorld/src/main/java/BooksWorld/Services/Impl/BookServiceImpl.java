package BooksWorld.Services.Impl;

import BooksWorld.Models.DTO.BookDetailsDTO;
import BooksWorld.Models.DTO.CreateBookDTO;
import BooksWorld.Models.Entitys.Book;
import BooksWorld.Models.Entitys.User;
import BooksWorld.Repositories.BookRepository;
import BooksWorld.Repositories.UserRepository;
import BooksWorld.Services.BookService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    public BookServiceImpl(BookRepository bookRepository, UserRepository userRepository) {
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public void createBook(CreateBookDTO createBookDTO,String name) throws Exception {
        Optional<User> byEmail = userRepository.findByEmail(name);
        if (byEmail.isEmpty()) {
            throw new Exception ("User dont exist!");
        }
        Book book = mapToEntity(createBookDTO);
        book.setIsOwner(byEmail.get());
        bookRepository.save(book);
        byEmail.get().getMyBooks().add(book);
        userRepository.save(byEmail.get());
    }

    private BookDetailsDTO mapToDetails(Book book) {
       return new BookDetailsDTO(book.getBookName(), book.getAuthor(), book.getImageUrl(), book.getGenre(), book.isOnLoad());
    }

    private Book mapToEntity(CreateBookDTO createBookDTO) {
        Book book = new Book();
        book.setBookName(createBookDTO.getBookName());
        book.setAuthor(createBookDTO.getAuthor());
        book.setGenre(createBookDTO.getGenre());
        book.setImageUrl(createBookDTO.getImageUrl());
        return book;
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
