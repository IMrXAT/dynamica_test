package nsu.rodionov.dynamica.app;

import nsu.rodionov.dynamica.core.book.service.BookService;
import nsu.rodionov.dynamica.core.client.service.ClientService;
import nsu.rodionov.dynamica.core.clientbook.dto.ClientBookDto;
import nsu.rodionov.dynamica.domain.Book;
import nsu.rodionov.dynamica.domain.Client;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/library")
public class LibraryController {

    private final BookService bookService;
    private final ClientService clientService;

    public LibraryController(BookService bookService, ClientService clientService) {
        this.bookService = bookService;
        this.clientService = clientService;
    }

    @GetMapping("/borrow-book")
    public String showBorrowBookForm(Model model) {
        // Добавляем список всех клиентов и всех книг в модель
        List<Client> clients = clientService.getAllClients();
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("clients", clients);
        model.addAttribute("books", books);
        model.addAttribute("borrowBookDto", new ClientBookDto());

        return "clients/borrow-book";
    }

    @PostMapping("/borrow-book")
    public String takeBook(@ModelAttribute ClientBookDto borrowBookDto) {
        clientService.takeBook(borrowBookDto.getClientId(), borrowBookDto.getIsbn());
        return "redirect:/library/borrow-book";
    }
}
