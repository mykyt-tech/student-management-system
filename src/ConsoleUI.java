import java.util.Scanner;
import java.util.stream.Stream;

public class ConsoleUI {
    private ConsoleUI() {}

    public static void showMenu() {
        boolean running = true;

        while (running) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("----------------------------------------");
            System.out.println("Please choose an option:");
            System.out.println("1. Add new student");
            System.out.println("2. Update student information");
            System.out.println("3. Add new grade for student");
//            System.out.println("4. View student GPA");
//            System.out.println("5. Search student by ID or name");
//            System.out.println("6. Export student list to a text file");
            System.out.println("7. Exit");
            System.out.println("----------------------------------------");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine();
            int id;
            String name;
            int age;

            switch (choice) {
                case "1":
                    System.out.println("----------------------------------------");
                    System.out.print("Enter student name: ");
                    name = scanner.nextLine();

                    System.out.print("Enter student age: ");
                    age = scanner.nextInt();

                    boolean studentAdded = School.addNewStudent(name, age);
                    if (studentAdded) {
                        System.out.println("----------------------------------------");
                        System.out.println("New student successfully added.");
                        System.out.println("----------------------------------------");
                    } else {
                        System.out.println("----------------------------------------");
                        System.out.println("Something went wrong.");
                        System.out.println("New student cannot be added.");
                        System.out.println("----------------------------------------");
                    }

                    break;
                case "2":
                    System.out.println("----------------------------------------");
                    System.out.print("Enter student id: ");
                    id = scanner.nextInt();

                    scanner.nextLine();

                    System.out.print("Enter student name: ");
                    name = scanner.nextLine();

                    System.out.print("Enter student age: ");
                    age = scanner.nextInt();
                    System.out.println("----------------------------------------");

                    boolean nameUpdated = School.updateStudentName(id, name);
                    boolean ageUpdated = School.updateStudentAge(id, age);

                    if (nameUpdated && ageUpdated) {
                        System.out.println("----------------------------------------");
                        System.out.println("Student information successfully updated.");
                        System.out.println("----------------------------------------");
                    } else {
                        System.out.println("----------------------------------------");
                        System.out.println("Something went wrong.");

                        if (!nameUpdated) {
                            System.out.println("Student name was not updated.");
                        }

                        if (!ageUpdated) {
                            System.out.println("Student age was not updated.");
                        }

                        System.out.println("----------------------------------------");
                    }

                    break;
                case "3":
                    double grade;
                    System.out.println("----------------------------------------");
                    System.out.print("Enter student id: ");
                    id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter new student grade: ");
                    grade = scanner.nextDouble();
                    System.out.println("----------------------------------------");

                    boolean gradeAdded = School.addNewGrade(id, grade);
                    if (gradeAdded) {
                        System.out.println("----------------------------------------");
                        System.out.println("New grade successfully added.");
                        System.out.println("----------------------------------------");
                    } else {
                        System.out.println("----------------------------------------");
                        System.out.println("Something went wrong.");
                        System.out.println("New grade cannot be added.");
                        System.out.println("----------------------------------------");
                    }

                    break;
                case "7":
                    running = false;
                    break;
                default:
                    System.out.println("Incorrect option.");
            }
        }
    }
}
