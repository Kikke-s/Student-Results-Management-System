import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ResultManager manager = new ResultManager();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n==== Student Result Management ====");
            System.out.println("1. Add Student");
            System.out.println("2. Add Teacher");
            System.out.println("3. Assign Score");
            System.out.println("4. Display Students");
            System.out.println("5. Display Teachers");
            System.out.println("6. Remove Student");
            System.out.println("7. Remove Teacher");
            System.out.println("8. Clear All Data");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");

            int choice;

            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number from 1 to 9.");
                continue;
            }

            switch (choice) {
                case 1: // Add Student
                    System.out.print("Enter Student ID: ");
                    String sid = sc.nextLine().trim();

                    if (sid.isEmpty()) {
                        System.out.println("Student ID cannot be empty.");
                        break;
                    }

                    System.out.print("Enter Student Name: ");
                    String sname = sc.nextLine().trim();

                    if (sname.isEmpty()) {
                        System.out.println("Student name cannot be empty.");
                        break;
                    }

                    manager.addStudent(new Student(sname, sid));
                    break;


                case 2: // Add Teacher
                    System.out.print("Enter Teacher ID: ");
                    String tid = sc.nextLine().trim();

                    if (tid.isEmpty()) {
                        System.out.println("Teacher ID cannot be empty.");
                        break;
                    }

                    System.out.print("Enter Teacher Name: ");
                    String tname = sc.nextLine().trim();

                    if (tname.isEmpty()) {
                        System.out.println("Teacher name cannot be empty.");
                        break;
                    }

                    System.out.print("Enter Subject Taught: ");
                    String subject = sc.nextLine().trim();

                    if (subject.isEmpty()) {
                        System.out.println("Subject cannot be empty.");
                        break;
                    }

                    manager.addTeacher(new Teacher(tname, tid, subject));
                    break;


                case 3: // Assign Score
                    System.out.print("Enter Teacher ID: ");
                    String tid2 = sc.nextLine();
                    Teacher teacher = manager.getTeacher(tid2);

                    if (teacher == null) {
                        System.out.println("Teacher not found!");
                        break;
                    }

                    System.out.print("Enter Student ID: ");
                    String sid2 = sc.nextLine();
                    Student student = manager.getStudent(sid2);

                    if (student == null) {
                        System.out.println("Student not found!");
                        break;
                    }

                    System.out.print("Enter Score: ");

                    int score;

                    try {
                        score = Integer.parseInt(sc.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a valid number.");
                        break;
                    }

                    teacher.assignScore(student, score);
                    manager.addStudent(student); // save updated student
                    break;

                case 4: // Display Students
                    manager.displayStudents();
                    break;

                case 5: // Display Teachers
                    manager.displayTeachers();
                    break;

                case 6: // Remove Student
                    System.out.print("Enter Student ID to remove: ");
                    String removeSid = sc.nextLine();
                    manager.removeStudent(removeSid);
                    break;

                case 7: // Remove Teacher
                    System.out.print("Enter Teacher ID to remove: ");
                    String removeTid = sc.nextLine();
                    manager.removeTeacher(removeTid);
                    break;

                case 8: // Clear All Data
                    manager.clearAll();
                    break;

                case 9: // Exit
                    System.out.println("Goodbye!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid option. Try again!");
            }
        }
    }
}