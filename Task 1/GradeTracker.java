import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class GradeTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> grades = new ArrayList<>();

        System.out.print("Enter the number of students: ");
        int numberOfStudents = scanner.nextInt();

        for (int i = 0; i < numberOfStudents; i++) {
            System.out.print("Enter grade for student " + (i + 1) + ": ");
            int grade = scanner.nextInt();
            while (grade < 0 || grade > 100) {
                System.out.print("Invalid grade. Enter a grade between 0 and 100: ");
                grade = scanner.nextInt();
            }
            grades.add(grade);
        }

        double sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        double average = sum / grades.size();

        int highest = Collections.max(grades);
        int lowest = Collections.min(grades);

        System.out.println("\n--- Grade Summary ---");
        System.out.println("Grades: " + grades);
        System.out.printf("Average Grade: %.2f\n", average);
        System.out.println("Highest Grade: " + highest);
        System.out.println("Lowest Grade: " + lowest);
    }
}
