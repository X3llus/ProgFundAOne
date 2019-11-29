package sample;

import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;

// Class for my javaFX table
public class Mark {

    // makes my variables for each columns
    private SimpleStringProperty grade = null;
    private SimpleStringProperty instructor = null;
    private SimpleStringProperty cName = null;
    private SimpleStringProperty cCode = null;
    private SimpleStringProperty letter = null;

    /**
     * initializing the object
     * @param grade
     * @param instructor
     * @param cName
     * @param cCode
     * @param letter
     */
    public Mark(String grade, String instructor, String cName, String cCode, String letter) {
        this.grade = new SimpleStringProperty(grade);
        this.instructor = new SimpleStringProperty(instructor);
        this.cName = new SimpleStringProperty(cName);
        this.cCode = new SimpleStringProperty(cCode);
        this.letter = new SimpleStringProperty(letter);
    }

    // All my getter and setter functions
    public String getGrade() {
        return grade.get();
    }

    public SimpleStringProperty gradeProperty() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade.set(grade);
    }

    public String getInstructor() {
        return instructor.get();
    }

    public SimpleStringProperty instructorProperty() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor.set(instructor);
    }

    public String getcName() {
        return cName.get();
    }

    public SimpleStringProperty cNameProperty() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName.set(cName);
    }

    public String getcCode() {
        return cCode.get();
    }

    public SimpleStringProperty cCodeProperty() {
        return cCode;
    }

    public void setcCode(String cCode) {
        this.cCode.set(cCode);
    }

    public String getLetter() {
        return letter.get();
    }

    public SimpleStringProperty letterProperty() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter.set(letter);
    }
}
