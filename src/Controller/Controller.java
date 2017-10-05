package Controller;

import Model.Notebook;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.MouseEvent;

public class Controller {

    public ListView lstView;
    public Button btnSave;
    public TextArea txtView;
    public Button btnDelete;
    public Button btnNewNote;
    public TextField txtTitle;
    public Label lblStatus;
    private Notebook notebook;

    public Controller() {
        notebook = new Notebook();

        lstView = new ListView();
    }

    public void btnNewNote(ActionEvent actionEvent) {
        txtTitle.requestFocus();
        btnSave.setDisable(false);
    }

    public void btnSave(ActionEvent actionEvent) {
        String title = txtTitle.getText();
        String newNote = txtView.getText();

        notebook.add(title + newNote);

        populateList();

        lblStatus.setText(title + " Saved...");
    }

    // Triggered when on mouse click, deletes selected item in the list
    public void btnDelete(ActionEvent actionEvent) {

        notebook.remove(selectItem());
        lblStatus.setText("Note deleted...");

        populateList();
    }

    // Triggered when on mouse click, displays selected item
    public void listSelected(MouseEvent mouseEvent) {

        // Calls selectedItem to get index
        String currentNote = notebook.getNotes().get(selectItem());

        txtView.setText(currentNote);
        btnDelete.setDisable(false);
    }

    public void txtViewChangedtext(InputMethodEvent inputMethodEvent) {

    }

    // Clears the two text boxes
    private void clear() {

        txtTitle.clear();
        txtView.clear();
    }

    // Returns the selected item in the listview
    private int selectItem(){
        return lstView.getSelectionModel().getSelectedIndex();
    }

    // Populates list and clears texts
    private void populateList() {

        lstView.getItems().clear();
        for (String note : notebook.getNotes()) {
            lstView.getItems().add(note);
        }

        clear();

        // Select first item in the list
        lstView.getSelectionModel().select(0);
    }
}
