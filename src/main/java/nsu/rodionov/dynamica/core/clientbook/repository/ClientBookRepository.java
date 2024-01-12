package nsu.rodionov.dynamica.core.clientbook.repository;

import nsu.rodionov.dynamica.core.clientbook.dto.ClientBookInfoDto;
import nsu.rodionov.dynamica.domain.ClientBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClientBookRepository extends JpaRepository<ClientBook, Long> {

    @Query("SELECT new nsu.rodionov.dynamica.core.clientbook.dto.ClientBookInfoDto(" +
            "book.isbn, book.author, book.title, client.birthday, client.firstName, client.lastName, client.patronymic, clientBook.receiveDate) " +
            "FROM Book book " +
            "JOIN ClientBook clientBook ON book.isbn = clientBook.book.isbn " +
            "JOIN Client client ON client.id = clientBook.client.id")
    List<ClientBookInfoDto> findAllClientBooks();
}
