package com.example.project_api_chat.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.project_api_chat.Model.Room;
import com.example.project_api_chat.service.RoomService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/rooms") // Base path for all room-related endpoints
public class RoomController {
    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    // Endpoint to create a new room
    @PostMapping
    public ResponseEntity<Room> createRoom(@RequestBody Room room) {
        Room createdRoom = roomService.newRoom(room);
        return new ResponseEntity<>(createdRoom, HttpStatus.CREATED);
    }

    // Endpoint to join a room by code
    @PutMapping("/{code}/join")
    public ResponseEntity<Void> joinRoom(@PathVariable String code, @RequestParam String username,@RequestBody Room room) {
        roomService.newUser(code, username, room);;
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // Endpoint to list rooms for a given username
    @GetMapping
    public ResponseEntity<List<Room>> getRooms(@RequestParam String username) {
        List<Room> rooms = roomService.getRooms(username);
        return new ResponseEntity<>(rooms, HttpStatus.OK);
    }
}
