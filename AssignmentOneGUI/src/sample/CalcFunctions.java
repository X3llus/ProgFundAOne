package sample;

import java.util.ArrayList;
import java.util.List;

public class CalcFunctions {

    /**
     * check the input grade to see if it is a number between 0 and 100
     * @param inGrade
     * @return true or false
     */
    static boolean checkInput(String inGrade) {
        String errMsg = "number must be between 0 and 100";
        try {
            // check if number
            float grade = Float.parseFloat(inGrade);

            // check if in range
            if (grade >= 0 && grade <= 100) {
                return true;
            } else {
                // Display the error message if the number is not in range
                System.err.println(errMsg);
                return false;
            }
        } catch (NumberFormatException e) {
            // display error message if not a number
            System.err.println(errMsg);
            return false;
        }
    }

    /**
     * method to return a letter grade from an inputted mark
     * @param mark
     * @return a letter grade
     */
    static String getLetter(float mark) {
        if (mark >= 90) {
            return "A+";
        } else if (mark >= 80 && mark <= 89) {
            return "A";
        } else if (mark >= 75 && mark <= 79) {
            return "B+";
        } else if (mark >= 70 && mark <= 74) {
            return "B";
        } else if (mark >= 65 && mark <= 69) {
            return "C+";
        } else if (mark >= 60 && mark <= 64) {
            return "C";
        } else if (mark >= 55 && mark <= 59) {
            return "D+";
        } else if (mark >= 50 && mark <= 54) {
            return "D";
        } else {
            return "E";
        }
    }

    /**
     * method to get average of list of grades
     * @param grades
     * @return
     */
    static double getAverage (List<Float> grades) {
        return grades.stream().mapToDouble(i -> i).average().getAsDouble();
    }
}
