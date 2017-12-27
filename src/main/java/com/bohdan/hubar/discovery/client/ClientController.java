package com.bohdan.hubar.discovery.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientController {

    private ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping(value = "/clients")
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @PostMapping(value = "/clients")
    public Client createClient(@RequestBody Client client) {
        return clientService.createClient(client);
    }
}
