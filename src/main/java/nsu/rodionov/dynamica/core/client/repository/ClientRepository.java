package nsu.rodionov.dynamica.core.client.repository;

import nsu.rodionov.dynamica.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Clientrepository extends JpaRepository<Client, Long> {
}
