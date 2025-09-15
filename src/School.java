import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

public class School {
    private static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("  WELCOME TO STUDENT MANAGEMENT SYSTEM  ");
        System.out.println("========================================\n");

        ConsoleUI.showMenu();
    }

    public static boolean addNewStudent(String name, int age) {
        return students.add(new Student(students.size() + 1, name, age));
    }

    public static boolean updateStudentName(int id, String name) {
        Student student = findStudentById(id);

        if (student != null) {
            student.setName(name);
            return true;
        }

        return false;
    }

    public static boolean updateStudentAge(int id, int age) {
        Student student = findStudentById(id);

        if (student != null) {
            student.setAge(age);
            return true;
        }

        return false;
    }

    public static boolean addNewGrade(int id, double grade) {
        Student student = findStudentById(id);

        if (student != null) {
            return student.addGrade(grade);
        }

        return false;
    }

    public static double getStudentGPA(int id) {
        Student student = findStudentById(id);

        if (student != null) {
            return student.calculateGPA();
        }

        return -1;
    }

    public static Student searchStudentByIdOrName(int id, String name, boolean byName) {
        for (Student student : students) {
            if (!byName) {
                if (student.getId() == id) {
                    return student;
                }
            } else {
                if (student.getName().equals(name)) {
                    return student;
                }
            }
        }

        return null;
    }

    public static boolean exportSortedStudentListToFile() {
        try (FileWriter writer = new FileWriter("students.txt")) {
            ArrayList<Student> studentsCopy = new ArrayList<>(students);

            studentsCopy.sort(Comparator.comparingDouble(Student::calculateGPA));

            for (Student student : studentsCopy) {
                writer.write(String.valueOf(student));
            }

            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static Student findStudentById(int id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                return students.get(i);
            }
        }

        return null;
    }
}