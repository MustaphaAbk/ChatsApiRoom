package com.example.project_api_chat.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.project_api_chat.Model.Message;
import com.example.project_api_chat.repositories.MessageRepository;

import jakarta.transaction.Transactional;

@Service
public class MessageService {
    private MessageRepository messageRepository;

    
    public MessageService(MessageRepository messageRepository){
        this.messageRepository=messageRepository;
    }

    @Transactional
    public Message newMessage(Message message){
        return messageRepository.save(message);
    }

    @Transactional
    public void deleteMessage(Long id){
        messageRepository.deleteById(id);
    }

    @Transactional
    public List<Message> getMessages(Long idLong){
        return messageRepository.findByRoomId(idLong);
    }
}
