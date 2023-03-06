package main.model;

import java.util.List;

public interface Repository {
    List<Note> getAllNotes();

    String createNote(Note note);

    void saveNote(List<Note> users);

    void deleteNote(Note note);

    void editNote(Note note);

}