import java.util.ArrayList;

public class Student {
    private int id;
    private String name;
    private int age;
    private final ArrayList<Double> grades = new ArrayList<>();

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Student(Student student) {
        this.id = student.getId();
        this.name = student.getName();
        this.age = student.getAge();
    }

    public int getId() { return id; }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean addGrade(double grade) {
        return grades.add(grade);
    }

    public double calculateGPA() {
        double sum = 0;

        for (double grade : grades) {
            sum += grade;
        }

        return sum / grades.size();
    }

    public void displayInfo() {
        System.out.println("Id: " + id);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.print("Grades: ");

        for (int i = 0; i < grades.size(); i++) {
            System.out.print(grades.get(i) + ", ");
        }

        System.out.println();
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", grades=" + grades +
                '}';
    }
}
