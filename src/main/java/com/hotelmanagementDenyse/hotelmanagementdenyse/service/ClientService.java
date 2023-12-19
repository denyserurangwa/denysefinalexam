package com.hotelmanagementDenyse.hotelmanagementdenyse.service;

import com.hotelmanagementDenyse.hotelmanagementdenyse.model.Client;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ClientService {
    Client findClientById(Integer cId);
    Client client(Client client);

    void deleteClient(Integer cId);
    Client updateClient(Client client);
    List<Client> getClient();
}