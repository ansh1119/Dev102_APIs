package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotesService {
    @Autowired
    NotesRepository<U, S> repo;

    public void addNote(Note note){
        repo.save(note);
    }

    public List<Note> getNotes() {
        return repo.findAll();
    }

    public void createUser(User user) {
    }
}
