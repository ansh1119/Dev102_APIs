package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/notes")
public class MyController {
    @Autowired
    NotesService service;


    @PostMapping("/add")
    public Note message(@RequestBody Note note) {
        service.addNote(note);
        return note;
    }
    @GetMapping("/get/{username}")
    public List<Note> getNotes(@PathVariable String username){
        return service.getNotes();
    }

    @DeleteMapping
    public void deleteNotes(){
    }
    @PostMapping("/create-user")
    public void createUser(@RequestBody User user){
        service.createUser(user);
    }


}


