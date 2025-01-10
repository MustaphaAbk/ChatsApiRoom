package com.example.project_api_chat.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.project_api_chat.Model.Personne;

@Repository
public interface PersonneRepository extends JpaRepository<Personne,Long>{
    
} 
