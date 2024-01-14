package nsu.rodionov.dynamica.app;


import nsu.rodionov.dynamica.core.client.dto.ClientDto;
import nsu.rodionov.dynamica.core.client.mapper.ClientMapper;
import nsu.rodionov.dynamica.core.client.service.ClientService;
import nsu.rodionov.dynamica.domain.Client;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/client")
public class ClientController {

    private final ClientService service;
    private final ClientMapper clientMapper;

    public ClientController(ClientService service, ClientMapper clientMapper) {
        this.service = service;
        this.clientMapper = clientMapper;
    }
    @GetMapping("")
    public String getAllClients(Model model){
        List<Client> clients = service.getAllClients();
        List<ClientDto> clientDtoList = clientMapper.toListDtoFromListEntity(clients);
        model.addAttribute("clients", clientDtoList);
        return "clients/list";
    }
    @PostMapping("/new")
    public String addClient(@ModelAttribute ClientDto clientDtoInfo, Model model){
        Client newClient = clientMapper.toNewEntity(clientDtoInfo);
        service.addClient(newClient);
        return getAllClients(model);
    }
    @PostMapping("/update")
    public String updateClient(Model model, @ModelAttribute ClientDto clientDto){
        service.updateClient(clientDto.getId(), clientDto);
        return getAllClients(model);
    }
}
