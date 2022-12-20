package com.ariza.pruebaalianza.cliente;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Predicate;

@Service
public class ClientService {
    private static List<Client> clients = new ArrayList<>();

    static {
        Client client1 = new Client("jgutierrez", "Juliana Gutierrez", "3211345869", "jgurtierrez@gmail.com", new Date(), new Date());
        Client client6 = new Client("jgutierrez2", "Juliana Gutierrez", "3211345869", "jgurtierrez@gmail.com", new Date(), new Date());
        Client client2 = new Client("mmartinez", "Manuel Martinez", "3018765489", "mmartinez@gmail.com", new Date(), new Date());
        Client client3 = new Client("oruiz", "Oscar Ruiz", "3186754987", "oruiz@gmail.com", new Date(), new Date());
        Client client4 = new Client("agarcia", "Ana Garcia", "3114867586", "agarcia@gmail.com", new Date(), new Date());
        Client client5 = new Client("tramos", "Tania Ramos", "3008765394", "tramos@gmail.com", new Date(), new Date());
        clients.add(client1);
        clients.add(client2);
        clients.add(client3);
        clients.add(client4);
        clients.add(client5);
        clients.add(client6);
    }

    public List<Client> getAllClients() {
        return clients;
    }

    public List<Client> getClientBySharedKey(String sharedKey) {
        Predicate<? super Client> predicate = Client -> Objects.equals(Client.getSharedKey(), sharedKey);
        List<Client> clients1 = clients.stream().filter(x -> x.getSharedKey().contains(sharedKey)).toList();
        if (clients1.isEmpty()) return null;
        return clients1;
    }

    public String addNewClient(Client client) {
        String[] sharedKey = client.getName().split(" ");
        client.setSharedKey((sharedKey[0].toLowerCase().charAt(0) + sharedKey[1].toLowerCase()));
        clients.add(client);
        return client.getSharedKey();
    }

    public List<Client> advancedSearch(Client client) {
        List<Client> clients1 = clients.stream().filter(cli ->
                cli.getName().equals(client.getName()) ||
                        cli.getPhone().equals(client.getSharedKey()) ||
                        cli.getEmail().equals(client.getEmail()) ||
                        cli.getEndDate().equals(client.getEndDate()) ||
                        cli.getStarDate().equals(client.getStarDate())
        ).toList();
        if (clients1.isEmpty()) return null;
        return clients1;
    }
}
