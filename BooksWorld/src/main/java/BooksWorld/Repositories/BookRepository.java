package BooksWorld.Repositories;

import BooksWorld.Models.Entitys.Book;
import BooksWorld.Models.Entitys.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByAuthorContainingIgnoreCaseOrBookNameContainingIgnoreCase(String key1, String key2);

    List<Book> findAllByIsOwner(User user);

    List<Book> findAllByIsOwnerIsNot(User user);
}
