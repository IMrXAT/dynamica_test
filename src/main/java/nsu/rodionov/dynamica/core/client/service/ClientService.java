package nsu.rodionov.dynamica.core.client.service;

import jakarta.transaction.Transactional;
import nsu.rodionov.dynamica.core.book.service.BookService;
import nsu.rodionov.dynamica.core.client.dto.ClientDto;
import nsu.rodionov.dynamica.core.client.exception.ClientNotFoundException;
import nsu.rodionov.dynamica.core.client.mapper.ClientMapper;
import nsu.rodionov.dynamica.core.client.repository.ClientRepository;
import nsu.rodionov.dynamica.core.clientbook.dto.ClientBorrowBookInfoDto;
import nsu.rodionov.dynamica.core.clientbook.repository.ClientBookRepository;
import nsu.rodionov.dynamica.domain.Book;
import nsu.rodionov.dynamica.domain.Client;
import nsu.rodionov.dynamica.domain.ClientBook;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ClientService {
    private final ClientRepository repository;
    private final ClientBookRepository clientBookRepository;
    private final ClientMapper mapper;
    private final BookService bookService;

    public ClientService(ClientRepository repository, ClientBookRepository clientBookRepository, ClientMapper mapper, BookService bookService) {
        this.repository = repository;
        this.clientBookRepository = clientBookRepository;
        this.mapper = mapper;
        this.bookService = bookService;
    }

    public List<Client> getAllClients() {
        return repository.findAll();
    }

    public Client getClientById(Long id){
        return repository.findById(id).orElseThrow(() -> new ClientNotFoundException("client with id " + id + " not found"));
    }
    public void addClient(Client newClient) {
        repository.save(newClient);
    }

    @Transactional
    public void updateClient(Long id, ClientDto clientDto) {
        Client clientToUpdate = getClientById(id);
        mapper.updateClientInfo(clientToUpdate, clientDto);
        repository.save(clientToUpdate);
    }

    @Transactional
    public void takeBook(Long id, String isbn) {
        Client client = getClientById(id);
        Book book = bookService.getBookByIsbn(isbn);

        ClientBook clientBook = new ClientBook();
        clientBook.setClient(client);
        clientBook.setBook(book);
        clientBook.setReceiveDate(LocalDate.now());

        clientBookRepository.save(clientBook);
    }

    public List<ClientBorrowBookInfoDto> findAllClientBooks(){
        return clientBookRepository.findAllClientBooks();
    }
}
