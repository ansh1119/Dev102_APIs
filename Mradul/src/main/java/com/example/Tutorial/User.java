package com.example.Tutorial;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import java.util.List;

public class User {

    @Id
    @Indexed(unique = true)
    private String Username;
    private String Pass;
    private List<ObjectId> notes;

    public List<ObjectId> getNotes() {
        return notes;
    }

    public void setNotes(List<ObjectId> notes) {
        this.notes = notes;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String pass) {
        Pass = pass;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }
}
