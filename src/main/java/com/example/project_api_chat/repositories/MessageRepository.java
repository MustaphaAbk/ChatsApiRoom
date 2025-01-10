package com.example.project_api_chat.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.project_api_chat.Model.Message;

public interface MessageRepository extends JpaRepository<Message,Long>{
    List<Message> findByRoomId(Long roomId);
}
