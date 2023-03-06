package main.model;

import java.util.Date;

public class Note {
    private int id;
    private String title;
    private String text;

    private String dateOfCreate;
    public static int quantitiOfNotes=0;

    public Note(String title, String text) {
        this.id = quantitiOfNotes;
        this.title = title;
        this.text = text;
        this.dateOfCreate = String.format("Дата создания - %S", new Date());
        quantitiOfNotes++;
    }

    public Note(String line, String line1, String line2, String line3) {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setDate() {
        this.dateOfCreate = String.format("Изменена - %s", new Date());
    }
    @Override
    public String toString() {
        return String.format("Идентафикатор: %s\nНазвание: %s,\nЗапись: %s\nСоздана: %s", id, title, text, dateOfCreate);
    }

    public String getDateOfCreate() {
        return dateOfCreate;
    }
}
