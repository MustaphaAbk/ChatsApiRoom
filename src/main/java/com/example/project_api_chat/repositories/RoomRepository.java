package com.example.project_api_chat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.project_api_chat.Model.Room;

import java.util.List;
import java.util.Optional;


public interface RoomRepository extends JpaRepository<Room,Long>{
    Optional<Room> findByCode(String code);
    List<Room> findByInRoom(String inRoom);
}
