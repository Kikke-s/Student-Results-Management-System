public class Teacher extends Person {
    private String subjectTaught;

    public Teacher(String name, String id, String subjectTaught) {
        super(name, id);
        this.subjectTaught = subjectTaught;
    }

    public String getSubjectTaught() {
        return subjectTaught;
    }

    public void assignScore(Student student, int score) {
        boolean added = student.addSubjectScore(this.subjectTaught, score);
        if (added) {
            System.out.println("✅ Score assigned successfully!");
        }
    }
}
