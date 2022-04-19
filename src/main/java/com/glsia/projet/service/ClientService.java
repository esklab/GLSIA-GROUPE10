package com.glsia.projet.service;

import com.glsia.projet.exception.UserNotFoundException;
import com.glsia.projet.modele.Client;
import com.glsia.projet.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client add (Client client ){
        client.setId(Integer.parseInt(UUID.randomUUID().toString()));
        return clientRepository.save(client);
    }

    public List<Client> findAll(){
        return clientRepository.findAll();
    }

    public Client update(Client client )
    {
        return clientRepository.save(client);
    }

    public Client findById(int id){



        return clientRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id "+ id + " was not found"));
    }

    public void delete(int id){
        clientRepository.deleteById(id);
    }
}
