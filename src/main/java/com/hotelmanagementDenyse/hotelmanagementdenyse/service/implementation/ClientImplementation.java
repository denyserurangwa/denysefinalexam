package com.hotelmanagementDenyse.hotelmanagementdenyse.service.implementation;

import com.hotelmanagementDenyse.hotelmanagementdenyse.model.Client;
import com.hotelmanagementDenyse.hotelmanagementdenyse.repository.ClientRepository;
import com.hotelmanagementDenyse.hotelmanagementdenyse.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClientImplementation implements ClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client findClientById(Integer cId) {
        return null;
    }

    @Override
    public Client client(Client client) {

        return clientRepository.save(client);
    }

    @Override
    public void deleteClient(Integer cId) {
        if(clientRepository.existsById(cId)){
            clientRepository.deleteById(cId);
        }
    }


    @Override
    public Client updateClient(Client client) {

        return null;
    }

    @Override
    public List<Client> getClient() {

        return clientRepository.findAll();
    }
}
