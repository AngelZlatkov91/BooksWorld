package BooksWorld.Services.Impl;

import BooksWorld.Models.DTO.BookDetailsDTO;
import BooksWorld.Models.DTO.CreateBookDTO;
import BooksWorld.Models.DTO.MyBooks;
import BooksWorld.Models.Entitys.Book;
import BooksWorld.Models.Entitys.User;
import BooksWorld.Repositories.BookRepository;
import BooksWorld.Repositories.UserRepository;
import BooksWorld.Services.BookService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
       return new BookDetailsDTO(book.getId(), book.getBookName(), book.getAuthor(), book.getImageUrl(), book.getGenre(), book.isOnLoad());
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
    @Transactional
    public void deleteBook(Long id, String email) {
        Optional<User> byEmail = userRepository.findByEmail(email);
        Optional<Book> byId = bookRepository.findById(id);
        if (!byId.get().isOnLoad()) {
            byEmail.get().getMyBooks().remove(byId.get());
            bookRepository.deleteById(id);
        }


    }

    @Override
    public List<BookDetailsDTO> getAllBooks(String email) {
        Optional<User> byEmail = userRepository.findByEmail(email);
        List<Book> allBooksExceptOwner = bookRepository.findAllByIsOwnerIsNot(byEmail.get());
        return allBooksExceptOwner.stream()
                .filter(book -> !book.isOnLoad())
                .map(this::mapToDetails)
                .collect(Collectors.toList());
    }

    @Override
    public MyBooks getAllBookByUser(String email) {
        Optional<User> byEmail = userRepository.findByEmail(email);
        List<Book> myBooks = byEmail.get().getMyBooks();
        List<Book> onLoanBooks = byEmail.get().getOnLoanBooks();
        List<BookDetailsDTO> myBooksList = myBooks.stream().map(this::mapToDetails).collect(Collectors.toList());
        List<BookDetailsDTO> onLoadBooksList = onLoanBooks.stream().map(this::mapToDetails).collect(Collectors.toList());
        MyBooks myBooks1 = new MyBooks();
        myBooks1.setMyBooks(myBooksList);
        myBooks1.setBarrowBooks(onLoadBooksList);
        return myBooks1;
    }

    @Override
    public void getTheBook(Long id, String name) {
        Optional<User> byEmail = userRepository.findByEmail(name);
        Optional<Book> byId = bookRepository.findById(id);
        byId.get().setOnLoad(true);
        byId.get().setOnLoadUser(byEmail.get());
        bookRepository.save(byId.get());
        byEmail.get().getOnLoanBooks().add(byId.get());
        userRepository.save(byEmail.get());

    }
}
