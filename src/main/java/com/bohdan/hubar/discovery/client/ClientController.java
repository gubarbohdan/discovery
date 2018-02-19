package com.bohdan.hubar.discovery.client;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientController {

    private ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @JsonView(Client.WithTripsView.class)
    @GetMapping(value = "/clients")
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @JsonView(Client.MinimalView.class)
    @PostMapping(value = "/clients")
    public Client createClient(@RequestBody Client client) {
        return clientService.createClient(client);
    }

    @JsonView(Client.WithTripsView.class)
    @GetMapping(value = "clients/{id}")
    public Client getClientById(@PathVariable Long id) {
        return clientService.findById(id);
    }
}
