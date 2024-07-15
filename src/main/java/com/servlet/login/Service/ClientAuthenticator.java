package com.servlet.login.Service;

import com.servlet.login.Model.Client;
import com.servlet.login.DAO.ClientDAO;

import java.util.ArrayList;
import java.util.List;

public class ClientAuthenticator {
    ClientDAO clientDAO = new ClientDAO();
    List<Client> clients = new ArrayList<Client>();

    public Client authenticate(Client client) {
        clients = clientDAO.findAll();
        if (clients.contains(client)) {
            client = clients.get(clients.indexOf(client));
            return client;
        }
        return null;
    }
}
