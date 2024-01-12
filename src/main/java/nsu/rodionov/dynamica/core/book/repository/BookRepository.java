package nsu.rodionov.dynamica.core.book.repository;

import nsu.rodionov.dynamica.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {
}
