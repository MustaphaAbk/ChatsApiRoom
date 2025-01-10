package com.example.project_api_chat.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Data @AllArgsConstructor @NoArgsConstructor
public class Personne {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_user;
    private String name;
    private String email;
    private String username;
    private String password;

}
