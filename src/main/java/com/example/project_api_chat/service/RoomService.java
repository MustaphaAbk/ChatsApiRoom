package com.example.project_api_chat.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.project_api_chat.Model.Room;
import com.example.project_api_chat.repositories.RoomRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class RoomService {
    private RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository){
        this.roomRepository=roomRepository;
    }

    @Transactional
    public Room newRoom(Room room){
        return roomRepository.save(room);
    }

    @Transactional
    public void newUser(String code,String username,Room room){
        Optional<Room> optionalRoom = roomRepository.findByCode(code);
        if ( optionalRoom.isPresent()){
            Room room1 = optionalRoom.get();
            room1.setId_room(room.getId_room());
            room1.setName(room.getName());
            room1.setDescription(room.getDescription());
            room1.setInRoom(room.getInRoom()+","+username);
            roomRepository.save(room1);
        }else{
            throw new EntityNotFoundException("Room not Found");
        }
    }

    @Transactional
    public List<Room> getRooms(String username){
        return roomRepository.findByInRoom(username);
    }
    
}
