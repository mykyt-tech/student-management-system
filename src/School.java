import java.util.ArrayList;

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
                    return new Student(student);
                }
            } else {
                if (student.getName().equals(name)) {
                    return new Student(student);
                }
            }
        }

        return null;
    }

    private static Student findStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }

        return null;
    }
}