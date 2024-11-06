import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {

    public static void main(String[] args) {
        ArrayList<Double> grades = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter a student's grade (or type 'done' to finish): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("done")) {
                break;
            }

            try {
                double grade = Double.parseDouble(input);
                if (grade >= 0 && grade <= 100) {
                    grades.add(grade);
                } else {
                    System.out.println("Please enter a grade between 0 and 100.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a numeric grade.");
            }
        }

        if (!grades.isEmpty()) {
            double total = 0;
            double highest = grades.get(0);
            double lowest = grades.get(0);

            for (double grade : grades) {
                total += grade;
                if (grade > highest) {
                    highest = grade;
                }
                if (grade < lowest) {
                    lowest = grade;
                }
            }

            double average = total / grades.size();

            System.out.println("\nGrade Summary:");
            System.out.println("Total number of grades entered: " + grades.size());
            System.out.printf("Average grade: %.2f%n", average);
            System.out.printf("Highest grade: %.2f%n", highest);
            System.out.printf("Lowest grade: %.2f%n", lowest);
        } else {
            System.out.println("No grades were entered.");
        }

        scanner.close();
    }
}