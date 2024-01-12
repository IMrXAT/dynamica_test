package nsu.rodionov.dynamica.app.rest;

import nsu.rodionov.dynamica.core.client.service.ClientService;
import nsu.rodionov.dynamica.core.clientbook.dto.ClientBookInfoDto;
import nsu.rodionov.dynamica.core.clientbook.mapper.ClientBookMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/library")
public class LibraryApiController {

    private final ClientService service;

    private ClientBookMapper mapper;
    public LibraryApiController(ClientService service) {
        this.service = service;
    }


    @GetMapping("")
    public List<ClientBookInfoDto> getAllClientsAllBorrowedBooks(){
        return  service.findAllClientBooks();
    }
}
