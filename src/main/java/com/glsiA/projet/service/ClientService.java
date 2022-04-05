package com.glsiA.projet.service;

import com.glsiA.projet.models.Client;
import com.glsiA.projet.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public  void saveClient(Client client){
        clientRepository.save(client);
    }

    public  void deleteClient(int id){
        clientRepository.deleteById(id);
    }

    public List<Client> showallClient()
    {
        return  clientRepository.findAll();
    }

    public Client  showClient( int id){
        Optional<Client> optional =clientRepository.findById(id);
        Client  client = null;
        if(optional.isPresent())
        {
            client= optional.get();
        }
        else
        {
            throw  new RuntimeException("id introuvable");
        }
        return  client;
    }

}
