package com.example.project_api_chat.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.project_api_chat.Model.Personne;
import com.example.project_api_chat.service.PersonneService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users") // Base path for user-related endpoints
public class UserController {
    private final PersonneService personneService;

    public UserController(PersonneService personneService) {
        this.personneService = personneService;
    }

    // Endpoint to create a new user
    @PostMapping("/new")
    public ResponseEntity<Personne> newUser(@RequestBody Personne personne) {
        Personne savedPersonne = personneService.newPersonne(personne);
        return new ResponseEntity<>(savedPersonne, HttpStatus.CREATED);
    }

    // Endpoint to update an existing user
    @PutMapping("/update/{id}")
    public ResponseEntity<Personne> updateUser(@PathVariable Long id,@RequestBody Personne personne) {
        Personne updatedPersonne = personneService.updatePersonne(id, personne);
        return new ResponseEntity<>(updatedPersonne, HttpStatus.OK);
    }

    // Endpoint to delete a user by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        personneService.deletePersonne(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
