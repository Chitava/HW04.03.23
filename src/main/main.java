package main;

import main.controllers.NoteController;
import main.model.FileOperation;
import main.model.FileOperationImpl;
import main.model.Repository;
import main.model.RepositoryFile;
import main.views.ViewNote;

public class main {
    public static void main(String[] args) {
        FileOperation fileOperation = new FileOperationImpl("users.txt");
        Repository repository = new RepositoryFile(fileOperation);
        NoteController controller = new NoteController(repository);
        ViewNote view = new ViewNote(controller);
        view.run();
    }
}
