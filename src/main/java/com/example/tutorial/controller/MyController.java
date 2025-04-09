package com.example.tutorial.controller;


import com.example.tutorial.entity.Note;
import com.example.tutorial.entity.User;
import com.example.tutorial.service.NoteService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
public class MyController {

//    @GetMapping("/message")
//    public String message(){
//        return "Hello world";
//    }
    @Autowired
NoteService service;

    @PostMapping("/add/{username}")
    public String message(@RequestBody Note note,@PathVariable String username){
        System.out.println(note.getContent());
        service.addNote(note);
        User user=service.getUserById(username);
        user.getNotesId().add(note.getId());
        return note.getId().toString();
    }

    @GetMapping("/get/{username}")
    public List<Note> getNotes(@PathVariable String username){
        return service.getNotes(username);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteNote(@PathVariable ObjectId id){
        service.deleteNote(id);
    }


    @PostMapping("/create-user")
    public void createUser(@RequestBody User user){
        service.createUser(user);
    }

}
