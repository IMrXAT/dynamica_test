package nsu.rodionov.dynamica.core.client.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ClientDto {
    public Long id;
    public String firstName;
    public String lastName;
    public String patronymic;
    public LocalDate birthday;
}
