package nsu.rodionov.dynamica.core.book.mapper;

import nsu.rodionov.dynamica.core.book.dto.BookDto;
import nsu.rodionov.dynamica.core.book.exception.BookMappingException;
import nsu.rodionov.dynamica.domain.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookMapper {
    public Book toNewEntity(BookDto newBookInfo) {
        Book book = new Book();
        if (newBookInfo == null) {
            throw new BookMappingException("Failed mapping new book, newBook is null");
        }
        System.out.println(newBookInfo.author + newBookInfo.title + newBookInfo.isbn);
        if (newBookInfo.isbn == null) {
            throw new BookMappingException("Failed mapping new book, book ISBN is null");
        }
        if (newBookInfo.title != null) {
            book.setTitle(newBookInfo.title);
        }
        if (newBookInfo.author != null) {
            book.setAuthor(newBookInfo.author);
        }
        book.setIsbn(newBookInfo.isbn);
        return book;
    }

    public List<BookDto> toListDtoFromListEntity(List<Book> books) {
        List<BookDto> dtoList = new ArrayList<>();
        for (Book book : books) {
            dtoList.add(toDtoFromEntity(book));
        }
        return dtoList;
    }

    private BookDto toDtoFromEntity(Book book) {
        BookDto dto = new BookDto();
        if (book.getIsbn() != null) {
            dto.isbn = book.getIsbn();
        }
        if (book.getAuthor() != null) {
            dto.author = book.getAuthor();
        }
        if (book.getTitle() != null) {
            dto.title = book.getTitle();
        }
        return dto;
    }
}
