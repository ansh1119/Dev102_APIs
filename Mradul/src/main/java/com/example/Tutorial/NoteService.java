package com.example.Tutorial;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {
    @Autowired
    NoteRepo repo;
    public void addNote(Note note){
        repo.save(note);
    }
    public List<Note> getNotes(){
        return repo.findAll();
    }

    public void deleteNotes(ObjectId id) {
        repo.deleteById(id.toString());
    }
}
