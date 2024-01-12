package nsu.rodionov.dynamica.core.client.repository;

import nsu.rodionov.dynamica.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
