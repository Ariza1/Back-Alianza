package com.ariza.pruebaalianza.cliente;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class ClientResource {

    private ClientService clientService;

    public ClientResource(ClientService clientService) {
        this.clientService = clientService;
    }

    @CrossOrigin(origins = "http://localhost:4200/")
    @GetMapping("/clients")
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @RequestMapping("clients/{sharedKey}")
    public Client getClientBySharedKey(@PathVariable String sharedKey) {
        Client client = clientService.getClientBySharedKey(sharedKey);
        if (client == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return client;
    }

    @RequestMapping(value = "/clients", method = RequestMethod.POST)
    public ResponseEntity<Object> addNewClient(@RequestBody Client client) {
        String sharedKey = clientService.addNewClient(client);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{sharedKey}").buildAndExpand(sharedKey).toUri();
        return ResponseEntity.created(uri).build();
    }

}
