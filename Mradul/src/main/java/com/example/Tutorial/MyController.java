package com.example.Tutorial;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
public class MyController {
    @Autowired
    NoteService noteService;
    UserService userService;

    @PostMapping("/add")
    public Note message(@RequestBody Note note) {
        System.out.println(note.getContent());
        noteService.addNote(note);
        System.out.println("Note Added");
        return note;
    }
    @GetMapping("/get")
    public List<Note> getNote(){
        return noteService.getNotes();
    }
    @DeleteMapping("/delete/{id}")
    public void deleteNote(@PathVariable ObjectId id){
        noteService.deleteNotes(id);
    }

    @PostMapping("/create-user")
    public User createUser(@RequestBody User User) {
//        System.out.println(.getContent());
        noteService.addNote(note);
        System.out.println("User Added");
        return note;
    }
    @GetMapping("/display")
    public List<Note> display(@RequestBody User user){
        return userService.displayMY();
    }
}
