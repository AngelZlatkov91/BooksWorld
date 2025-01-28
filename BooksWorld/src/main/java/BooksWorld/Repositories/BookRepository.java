package BooksWorld.Repositories;

import BooksWorld.Models.Entitys.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByAuthorContainingIgnoreCaseOrBookNameContainingIgnoreCase(String key1, String key2);


}
