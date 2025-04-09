package com.example.tutorial.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "users")
public class User {

    @Id
    @Indexed(unique = true)
    private String username;
    private String password;
    private List<ObjectId> notesId;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<ObjectId> getNotesId() {
        return notesId;
    }

    public void setNotesId(List<ObjectId> notesId) {
        this.notesId = notesId;
    }
}
