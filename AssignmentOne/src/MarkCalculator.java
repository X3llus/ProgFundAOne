import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

/**
        * <h1> Mark and Average Calculator Program </h1>
        * <p>Take six number grades and converts them into
        * their equivalent letter grade.</p>
        * <p>After that is will take the average of
        * the marks and display that with a letter grade.</p>
        */
class MarkCalculator {
    //----------------------------------------------------------------------------------------------------------------//
    // method to get an ArrayList of grades inputted by the user
    private static ArrayList<Float> getGrades (Scanner keyIn) {

        ArrayList<Float> grades = new ArrayList<>();
        String eMes = new String("The Grade must be in the range 0-100");

         /*gets six user inputted grades
         throws an exception if the mark is not in the acceptable range or is not a number and will ask again*/
        for(int i = 1; i <=6;) {
            System.out.printf("Enter grade %s: ", i);

            // Gets the users input and if it meets the requirements it will add it to the list
            try {
                float in = Float.parseFloat(keyIn.nextLine());

                if (in > 0 && in < 100) {
                    grades.add(in);
                    i++;
                } else { // Display the error message if the number is not in range
                    System.out.println(eMes);
                }
            } catch (NumberFormatException e) { // Display the error message if the input is not a number
                System.out.println(eMes);
            }
        }
        return grades;
    }

    //----------------------------------------------------------------------------------------------------------------//
    // method to return a letter grade from an inputted mark
    private static String getLetter(float mark) {
        if (mark >= 90) {
            return "an A+";
        } else if (mark >= 80 && mark <= 89) {
            return "an A";
        } else if (mark >= 75 && mark <= 79) {
            return "a B+";
        } else if (mark >= 70 && mark <= 74) {
            return "a B";
        } else if (mark >= 65 && mark <= 69) {
            return "a C+";
        } else if (mark >= 60 && mark <= 64) {
            return "a C";
        } else if (mark >= 55 && mark <= 59) {
            return "a D+";
        } else if (mark >= 50 && mark <= 54) {
            return "a D";
        } else {
            return "an E";
        }
    }

    //----------------------------------------------------------------------------------------------------------------//
    // method to get average of list of grades
    private static double getAverage (List<Float> grades) {
        return grades.stream().mapToDouble(i -> i).average().getAsDouble();
    }

    //----------------------------------------------------------------------------------------------------------------//
    // main method
    public static void main(String[] args) {
        Scanner keyIn = new Scanner(System.in);

        String[] courseNum = {"1rst", "2nd", "3rd", "4th", "5th", "6th"}; // Array with all course numbers formatted

        // creates an ArrayList from user inputted marks
        ArrayList<Float> grades = getGrades(keyIn);

        // outputs each grade with its letter grade
        for (int i = 0; i < 6; i++) {
            System.out.printf("The mark for the %s course is %.1f%% which is %s%n", courseNum[i], grades.get(i), getLetter(grades.get(i)));
        }

        // outputs the overall average and letter grade
        System.out.printf("%nThe average grade is a %.1f%% which is a %s%n", getAverage(grades), getLetter((float) getAverage(grades)));
    }
}