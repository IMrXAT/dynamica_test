package nsu.rodionov.dynamica.core.clientbook.dto;

import lombok.AllArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
public class ClientBookInfoDto {
    public String firstName;
    public String lastName;
    public String patronymic;
    public LocalDate birthday;

    public String bookName;
    public String author;
    public String isbn;

    public LocalDate receiveDate;
}
