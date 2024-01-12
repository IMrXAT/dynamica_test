package nsu.rodionov.dynamica.core.client.mapper;


import nsu.rodionov.dynamica.core.client.dto.ClientDto;
import nsu.rodionov.dynamica.domain.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {
    public Client toNewEntity(ClientDto clientDto) {
        Client client = new Client();
        if (clientDto == null) return client;
        updateClient(client, clientDto);
        return client;
    }

    public void updateClientInfo(Client clientToUpdate, ClientDto clientDto) {
        if (clientDto == null) return;
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
}
