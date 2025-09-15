import java.util.ArrayList;

public class School {
    private static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {}

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

    private static Student findStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }

        return null;
    }
}