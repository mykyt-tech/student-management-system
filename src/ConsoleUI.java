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
//            System.out.println("2. Update student information");
//            System.out.println("3. Add new grade for student");
//            System.out.println("4. View student GPA");
//            System.out.println("5. Search student by ID or name");
//            System.out.println("6. Export student list to a text file");
            System.out.println("7. Exit");
            System.out.println("----------------------------------------");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    String name;
                    int age;

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
                case "7":
                    running = false;
                    break;
                default:
                    System.out.println("Incorrect option.");
            }
        }
    }
}
