package com.example.tutorial.service;

import com.example.tutorial.entity.Note;
import com.example.tutorial.entity.User;
import com.example.tutorial.repository.NotesRepository;
import com.example.tutorial.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoteService {

    @Autowired
    NotesRepository repo;

    @Autowired
    UserRepository userRepo;

    public void addNote(Note note){
        repo.save(note);
    }

    public List<Note> getNotes(String username) {
        User user=getUserById(username);
        List<Note> list=new ArrayList<>();
        for(ObjectId id:user.getNotesId()){
            list.add(findNoteById(id));
        }
        return list;
    }

    public Note findNoteById(ObjectId id){
        return repo.findById(id.toString()).orElse(null);
    }

    public void deleteNote(ObjectId id) {
        repo.deleteById(id.toString());
    }


    public User getUserById(String username){
        return userRepo.findById(username).orElse(null);
    }

    public void createUser(User user) {
        userRepo.save(user);
    }
}
