package nsu.rodionov.dynamica.app;

import nsu.rodionov.dynamica.core.book.dto.BookDto;
import nsu.rodionov.dynamica.core.book.mapper.BookMapper;
import nsu.rodionov.dynamica.core.book.service.BookService;
import nsu.rodionov.dynamica.domain.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BooksController {

    private final BookService service;
    private final BookMapper bookMapper;

    public BooksController(BookService service, BookMapper bookMapper) {
        this.service = service;
        this.bookMapper = bookMapper;
    }

    @GetMapping("")
    public String getAllBooks(Model model){
        List<Book> books = service.getAllBooks();
        model.addAttribute("books", books);
        return "books/list";
    }

    @PostMapping("/new")
    public String addBook(@ModelAttribute BookDto bookDtoInfo, Model model){
        Book newBook = bookMapper.toNewEntity(bookDtoInfo);
        service.addBook(newBook);
        return "redirect:/book";
    }

    @PostMapping("/update")
    public String updateBook(Model model, @ModelAttribute BookDto bookDto){
        service.updateBook(bookDto.getIsbn(), bookDto);
        return "redirect:/book";
    }
}
