import java.io.*;
import java.util.*;

public class ResultManager {
    private Map<String, Student> students = new HashMap<>();
    private Map<String, Teacher> teachers = new HashMap<>();

    private final String STUDENTS_FILE = "students.txt";
    private final String TEACHERS_FILE = "teachers.txt";

    public ResultManager() {
        loadStudents();
        loadTeachers();
    }

    // Add student
    public void addStudent(Student student) {
        if (students.containsKey(student.getId())) {
            System.out.println("Student with ID " + student.getId() + " already exists!");
            return;
        }
        students.put(student.getId(), student);
        saveStudents();
    }

    // Add teacher
    public void addTeacher(Teacher teacher) {
        if (teachers.containsKey(teacher.getId())) {
            System.out.println("Teacher with ID " + teacher.getId() + " already exists!");
            return;
        }
        teachers.put(teacher.getId(), teacher);
        saveTeachers();
    }

    // Get student
    public Student getStudent(String id) {
        return students.get(id);
    }

    // Get teacher
    public Teacher getTeacher(String id) {
        return teachers.get(id);
    }

    // Save students to file
    private void saveStudents() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(STUDENTS_FILE))) {
            for (Student s : students.values()) {
                writer.print(s.getId() + "," + s.getName());
                for (Map.Entry<String, Integer> entry : s.getSubjects().entrySet()) {
                    writer.print("," + entry.getKey() + "=" + entry.getValue());
                }
                writer.println();
            }
        } catch (IOException e) {
            System.out.println("Error saving students: " + e.getMessage());
        }
    }

    // Save teachers to file
    private void saveTeachers() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(TEACHERS_FILE))) {
            for (Teacher t : teachers.values()) {
                writer.println(t.getId() + "," + t.getName() + "," + t.getSubjectTaught());
            }
        } catch (IOException e) {
            System.out.println("Error saving teachers: " + e.getMessage());
        }
    }

    // Load students from file
    private void loadStudents() {
        File file = new File(STUDENTS_FILE);
        if (!file.exists()) return;

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length >= 2) {
                    Student s = new Student(parts[1], parts[0]); // name, id
                    for (int i = 2; i < parts.length; i++) {
                        String[] sub = parts[i].split("=");
                        if (sub.length == 2) {
                            s.addSubjectScore(sub[0], Integer.parseInt(sub[1]));
                        }
                    }
                    students.put(s.getId(), s);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading students: " + e.getMessage());
        }
    }

    // Load teachers from file
    private void loadTeachers() {
        File file = new File(TEACHERS_FILE);
        if (!file.exists()) return;

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String[] parts = scanner.nextLine().split(",");
                if (parts.length == 3) {
                    Teacher t = new Teacher(parts[1], parts[0], parts[2]); // name, id, subject
                    teachers.put(t.getId(), t);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading teachers: " + e.getMessage());
        }
    }

    // Display all students
    public void displayStudents() {

        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        for (Student s : students.values()) {

            System.out.println("\n==============================");
            System.out.println("Student ID: " + s.getId());
            System.out.println("Student Name: " + s.getName());
            System.out.println("------------------------------");

            if (s.getSubjects().isEmpty()) {
                System.out.println("No scores recorded.");
            } else {
                System.out.println("Subjects and Scores:");

                for (Map.Entry<String, Integer> entry : s.getSubjects().entrySet()) {
                    System.out.println(
                            entry.getKey() + ": " + entry.getValue()
                    );
                }
            }

            System.out.println("------------------------------");
            System.out.printf("Average: %.2f%n", s.calculateAverage());
            System.out.println("Grade: " + s.calculateGrade());
            System.out.println("==============================");
        }
    }

    // Display all teachers
    public void displayTeachers() {
        for (Teacher t : teachers.values()) {
            System.out.println(t.getId() + " - " + t.getName() + " | Subject: " + t.getSubjectTaught());
        }
    }

    // Remove one student
    public void removeStudent(String id) {
        if (students.remove(id) != null) {
            saveStudents();
            System.out.println("Student removed successfully!");
        } else {
            System.out.println("No student found with ID " + id);
        }
    }

    // Remove one teacher
    public void removeTeacher(String id) {
        if (teachers.remove(id) != null) {
            saveTeachers();
            System.out.println("Teacher removed successfully!");
        } else {
            System.out.println("No teacher found with ID " + id);
        }
    }

    // Clear all data
    public void clearAll() {
        students.clear();
        teachers.clear();
        new File(STUDENTS_FILE).delete();
        new File(TEACHERS_FILE).delete();
        System.out.println("All data cleared!");
    }
}