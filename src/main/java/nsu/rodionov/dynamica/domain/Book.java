package nsu.rodionov.dynamica.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "book")
public class Book {
    @Id
    String isbn;

    @Column(name = "title")
    String title;

    @Column(name = "author")
    String author;

    @OneToMany(mappedBy = "book")
    private List<ClientBook> clientBooks;
}
