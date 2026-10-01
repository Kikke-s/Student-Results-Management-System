import java.util.HashMap;
import java.util.Map;

public class Student extends Person {
    private Map<String, Integer> subjects = new HashMap<>();

    public Student(String name, String id) {
        super(name, id);
    }

    public boolean addSubjectScore(String subject, int score) {

        if (score < 0 || score > 100) {
            System.out.println("Score must be between 0 and 100.");
            return false;
        }

        if (subjects.containsKey(subject)) {
            System.out.println("Student already has a score for " + subject);
            return false;
        }

        subjects.put(subject, score);
        return true;
    }

    public Map<String, Integer> getSubjects() {
        return subjects;
    }

    public double calculateAverage() {
        if (subjects.isEmpty()) return 0.0;
        int total = 0;
        for (int score : subjects.values()) {
            total += score;
        }
        return (double) total / subjects.size();
    }

    public String calculateGrade() {
        double avg = calculateAverage();
        if (avg >= 70) return "A";
        else if (avg >= 60) return "B";
        else if (avg >= 50) return "C";
        else if (avg >= 45) return "D";
        else if (avg >= 40) return "E";
        else return "F";
    }
}