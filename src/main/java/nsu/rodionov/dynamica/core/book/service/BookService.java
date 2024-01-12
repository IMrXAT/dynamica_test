package nsu.rodionov.dynamica.core.book.service;

import jakarta.transaction.Transactional;
import nsu.rodionov.dynamica.core.book.dto.BookDto;
import nsu.rodionov.dynamica.core.book.exception.BookNotFoundException;
import nsu.rodionov.dynamica.core.book.repository.BookRepository;
import nsu.rodionov.dynamica.domain.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    public void addBook(Book newBook) {
        repository.save(newBook);
    }

    @Transactional
    public void updateBook(String isbn, BookDto bookDto) {
        Book bookToUpdate = getBookByIsbn(isbn);
        updateBookInfo(bookToUpdate, bookDto);
        repository.save(bookToUpdate);
    }

    private void updateBookInfo(Book book, BookDto bookDto){
        if (bookDto.getAuthor() != null){
            book.setAuthor(bookDto.getAuthor());
        }
        if (bookDto.getBookName() != null){
            book.setTitle(bookDto.getBookName());
        }
    }

    @Transactional
    public Book getBookByIsbn(String isbn) {
        return repository.findById(isbn).orElseThrow(() -> new BookNotFoundException("book with isbn " + isbn + " not found"));
    }
}
