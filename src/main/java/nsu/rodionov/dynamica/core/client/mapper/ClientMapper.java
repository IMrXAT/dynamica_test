package nsu.rodionov.dynamica.core.client.mapper;


import nsu.rodionov.dynamica.core.client.dto.ClientDto;
import nsu.rodionov.dynamica.core.client.exception.ClientMappingException;
import nsu.rodionov.dynamica.domain.Client;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class ClientMapper {
    public Client toNewEntity(ClientDto clientDto) {
        Client client = new Client();
        if (clientDto == null) return client;
        if (LocalDate.now().isBefore(clientDto.birthday)){
            throw new ClientMappingException("your birthday cant be later then now");
        }
        updateClient(client, clientDto);
        return client;
    }

    public void updateClientInfo(Client clientToUpdate, ClientDto clientDto) {
        if (clientDto == null) return;
        if (LocalDate.now().isBefore(clientDto.birthday)){
            throw new ClientMappingException("your birthday cant be later then now");
        }
        updateClient(clientToUpdate, clientDto);
    }

    private void updateClient(Client clientToUpdate, ClientDto clientDto) {
        if (clientDto.firstName != null){
            clientToUpdate.setFirstName(clientDto.firstName);
        }
        if (clientDto.lastName != null){
            clientToUpdate.setLastName(clientDto.lastName);
        }
        if (clientDto.patronymic != null){
            clientToUpdate.setPatronymic(clientDto.patronymic);
        }
        if (clientDto.birthday != null){
            clientToUpdate.setBirthday(clientDto.birthday);
        }
    }

    public List<ClientDto> toListDtoFromListEntity(List<Client> clients) {
        List<ClientDto> dtoList = new ArrayList<>();
        for (Client client : clients){
            dtoList.add(toDtoFromEntity(client));
        }
        return dtoList;
    }

    private ClientDto toDtoFromEntity(Client client) {
        ClientDto dto = new ClientDto();
        if (client.getId() != null){
            dto.id = client.getId();
        }
        if (client.getBirthday() != null){
            dto.birthday = client.getBirthday();
        }
        if (client.getPatronymic() != null){
            dto.patronymic = client.getPatronymic();
        }
        if (client.getFirstName() != null){
            dto.firstName = client.getFirstName();
        }
        if (client.getLastName() != null){
            dto.lastName = client.getLastName();
        }
        return dto;

    }
}
