package main.views;

import main.controllers.NoteController;
import main.model.Note;

import java.util.List;
import java.util.Scanner;

public class ViewNote {
    private final NoteController noteController;

    public ViewNote(NoteController noteController) {
        this.noteController = noteController;
    }

    public void run() {
        Menu com;

        while (true) {
            String command = prompt("������� �������: ");
            try {
                com = Menu.valueOf(command.toUpperCase());

                if (com == Menu.EXIT) return;
                switch (com) {
                    case CREATE:
                        createUser();
                        break;
                    case UPDATE:
                        updateUser();
                        break;
                    case DELETE:
                        deleteUser();
                        break;
                    case ALL:
                        listUsers();
                        break;

                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void updateUser() throws Exception {
        int readId = Integer.parseInt(prompt("������� ������������� ID �����: "));
        noteController.updateNote(readId,inputUser());
    }

    private void listUsers() {
        List<Note> listUsers = noteController.readAllUsers();
        for (Note user : listUsers) {
            System.out.println(user + "\n");
        }
    }

    private void readUser() throws Exception {
        String id = prompt("������������� ������: ");

        Note user = noteController.readNote(Integer.parseInt(id));
        System.out.println(user);

    }

    private Note inputUser() {
        String title = prompt("�������� : ");
        String text = prompt("������: ");
        return new Note(title, text);
    }

    private void createUser() throws Exception {
        noteController.saveUser(inputUser());
    }


    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }

    private void deleteUser() throws Exception {
        String id = prompt("������� id ��������� ������: ");
        noteController.deleteNote(Integer.parseInt(id));
    }

    


}
