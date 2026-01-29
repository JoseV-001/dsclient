package com.josev001.dsclient.services;

import com.josev001.dsclient.dto.ClientDTO;
import com.josev001.dsclient.entities.Client;
import com.josev001.dsclient.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    public ClientDTO findById(Long id) {
       Client entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado!"));
       return new ClientDTO(entity);
    }

    public Page<ClientDTO> findAll(Pageable pageable) {
        Page<Client> result = repository.findAll(pageable);
        return result.map(x -> new ClientDTO(x));
    }

    public ClientDTO insert(ClientDTO dto){
        Client entity = new Client();
        copyToEntity(dto, entity);
        entity = repository.save(entity);
        return new ClientDTO(entity);
    }

//    public ClientDTO update(Long id, ClientDTO dto){
//        Client entity = repository.getReferenceById(id);
//        copyDtoEntity(dto, entity);
//    }


    private void copyToEntity(ClientDTO dto, Client entity){
        entity.setName(dto.getName());
        entity.setCpf(dto.getCpf());
        entity.setIncome(dto.getIncome());
        entity.setBirthDate(dto.getBirthDate());
        entity.setChildren(dto.getChildren());
    }


}
