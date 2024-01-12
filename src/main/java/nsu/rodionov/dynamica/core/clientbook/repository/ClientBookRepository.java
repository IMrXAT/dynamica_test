package nsu.rodionov.dynamica.core.clientbook;

import nsu.rodionov.dynamica.domain.ClientBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientBookRepository extends JpaRepository<ClientBook, Long> {
}
