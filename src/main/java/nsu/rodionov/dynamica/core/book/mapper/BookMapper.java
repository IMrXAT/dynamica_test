package nsu.rodionov.dynamica.core.book.mapper;

import nsu.rodionov.dynamica.core.book.dto.BookDto;
import nsu.rodionov.dynamica.core.book.exception.BookMappingException;
import nsu.rodionov.dynamica.domain.Book;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {
    public Book toNewEntity(BookDto newBookInfo){
        Book book = new Book();
        if (newBookInfo == null){
            throw new BookMappingException("Failed mapping new book, newBook is null");
        }
        System.out.println(newBookInfo.author + newBookInfo.bookName + newBookInfo.isbn);
        if (newBookInfo.isbn == null){
            throw new BookMappingException("Failed mapping new book, book ISBN is null");
        }
        if (newBookInfo.bookName != null){
            book.setTitle(newBookInfo.bookName);
        }
        if (newBookInfo.author != null){
            book.setAuthor(newBookInfo.author);
        }
        book.setIsbn(newBookInfo.isbn);
        return book;
    }
}
