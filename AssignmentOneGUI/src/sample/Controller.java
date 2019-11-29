package sample;

import java.util.List;
import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class Controller {

    //----------------------------------------------------------------------------------------------------------------//
    // set up all of my javaFX elements
    @FXML TextField cName;
    @FXML TextField cCode;
    @FXML TextField instructor;
    @FXML TextField grade;
    @FXML TableView<Mark> tableView;
    @FXML TableColumn<Mark, String> cNameCol;
    @FXML TableColumn<Mark, String> cCodeCol;
    @FXML TableColumn<Mark, String> instructorCol;
    @FXML TableColumn<Mark, String> gradeCol;
    @FXML TableColumn<Mark, String> letterCol;
    @FXML Label avgMsg;

    /**
     * function to take inputted data and add it to the table
     */
    @FXML
    private void addRow() {
        if (CalcFunctions.checkInput(grade.getText())) {
            // make a new row object and add it to the table
            tableView.getItems().add(new Mark(grade.getText(), instructor.getText(), cName.getText(), cCode.getText(), CalcFunctions.getLetter(Float.parseFloat(grade.getText()))));

            // reset the inputs
            grade.setText("");
            cName.setText("");
            cCode.setText("");
            instructor.setText("");

            getNewAverage();
        }
    }

    /**
     * function to get and remove the selected row
     */
    @FXML
    private void deleteRow() {
        Mark selectedItem = tableView.getSelectionModel().getSelectedItem();
        tableView.getItems().remove(selectedItem);

        getNewAverage();
    }

    /**
     * function run on program startup, binds the variables in the Mark class to the columns of the table
     */
    @FXML
    void initialize() {
        cNameCol.setCellValueFactory(new PropertyValueFactory<Mark, String>("cName"));
        cCodeCol.setCellValueFactory(new PropertyValueFactory<Mark, String>("cCode"));
        instructorCol.setCellValueFactory(new PropertyValueFactory<Mark, String>("instructor"));
        gradeCol.setCellValueFactory(new PropertyValueFactory<Mark, String>("grade"));
        letterCol.setCellValueFactory(new PropertyValueFactory<Mark, String>("letter"));

        tableView.setItems(getMarks());
    }

    /**
     * make a list of rows
     * @return a Mark list
     */
    public ObservableList<Mark> getMarks() {
         ObservableList<Mark> mark = FXCollections.observableArrayList();

         return mark;
    }

    /**
     * get all grades, calculate a new average from them, display that average
     */
    private void getNewAverage() {
        // checks to see if there are marks to get using try except
        try {
            // get the column
            TableColumn<Mark, String> column = gradeCol;

            // make a list of the values from that column
            List<String> columnData;
            columnData = new ArrayList<>();
            for (Mark item : tableView.getItems()) {
                columnData.add(column.getCellObservableValue(item).getValue());
            }

            // converts the list of strings to a list of floats
            List<Float> floatGrades = new ArrayList<>();
            for (int i = 0; i < columnData.size(); i++) {
                floatGrades.add(Float.parseFloat(columnData.get(i)));
            }

            // get the average of that list
            double average = CalcFunctions.getAverage(floatGrades);

            // update the label with a new average and letter grade
            String mes = String.format("The average mark is %.1f which translates to a letter of %s", average, CalcFunctions.getLetter((float) average));
            avgMsg.setText(mes);
        } catch (Exception e) {
            // if an error occurs, set the text in the label to be empty
            avgMsg.setText("");
        }
    }
}
