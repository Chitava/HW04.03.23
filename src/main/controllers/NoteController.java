package main.controllers;

import main.model.Note;
import main.model.Repository;
import java.util.List;

public class NoteController {
    private final Repository repository;

    public NoteController(Repository repository) {
        this.repository = repository;
    }

    public void createNote(Note note) throws Exception{
        repository.createNote(note);
    }
    public void saveUser(Note note) throws Exception {

        repository.createNote(note);
    }

    public Note readNote(int id) throws Exception {
        List<Note> notes = repository.getAllNotes();
        Note note = noteSearch(id, notes);
        return note;
    }

    private static Note noteSearch(int id, List<Note> notes) throws Exception {
        for (Note note : notes) {
            if (note.getId() == id) {
                return note;
            }
        }
        throw new Exception("Запись не найдена");
    }

    public List<Note> readAllUsers() {
        return repository.getAllNotes();
    }

    public void updateNote(int id, Note newNote) throws Exception {
        List<Note> notes = repository.getAllNotes();
        Note note = noteSearch(id, notes);
        note.setTitle(newNote.getTitle());
        note.setText(newNote.getText());
        note.setDate();
        repository.saveNote(notes);
    }

    public void deleteNote(int id) throws Exception {
        List<Note> notes = repository.getAllNotes();
        for (int i = 0; i < notes.size(); i++) {
            if (notes.get(i).getId() == id) {
                Note.quantitiOfNotes --;
                notes.remove(notes.get(i));
                for (int j = id+1; i < notes.size(); i++){
                    notes.get(id).setId(id);
                }
            }
            System.out.println(notes);
            repository.saveNote(notes);
        }
    }



}

