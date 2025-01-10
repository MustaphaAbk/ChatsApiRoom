package com.example.project_api_chat.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.project_api_chat.Model.Personne;
import com.example.project_api_chat.repositories.PersonneRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;


@Service 
public class PersonneService {
    
    private PersonneRepository personneRepository;

    public PersonneService(PersonneRepository personneRepository){
        this.personneRepository=personneRepository;
    }

    @Transactional
    public Personne newPersonne(Personne personne){
        return personneRepository.save(personne);
    }

    @Transactional
    public void deletePersonne(Long id){
        personneRepository.deleteById(id);;
    }

    @Transactional
    public Personne updatePersonne(Long id_user,Personne personne){
        Optional<Personne> optionalPersonne = personneRepository.findById(id_user);
        if (optionalPersonne.isPresent()){
            Personne personne2 = optionalPersonne.get();
            personne2.setName(personne.getName());
            personne2.setEmail(personne.getEmail());
            personne2.setUsername(personne.getUsername());
            personne2.setPassword(personne.getPassword());
            return personneRepository.save(personne2);
        }else{
            throw new EntityNotFoundException("user not found!");
        }   
    }
}
