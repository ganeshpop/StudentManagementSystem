public class Student {
    private int rollNumber, marksInEnglish, marksInMaths, marksInScience;
    private String studentName;

    public Student(int rollNumber, String studentName, int marksInEnglish, int marksInMaths, int marksInScience) {
        this.rollNumber = rollNumber;
        this.studentName = studentName;
        this.marksInEnglish = marksInEnglish;
        this.marksInMaths = marksInMaths;
        this.marksInScience = marksInScience;
    }
    public Student(String studentName, int marksInEnglish, int marksInMaths, int marksInScience) {
        this.studentName = studentName;
        this.marksInEnglish = marksInEnglish;
        this.marksInMaths = marksInMaths;
        this.marksInScience = marksInScience;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public int getMarksInEnglish() {
        return marksInEnglish;
    }

    public int getMarksInMaths() {
        return marksInMaths;
    }

    public int getMarksInScience() {
        return marksInScience;
    }

    public String getStudentName() {
        return studentName;
    }

}
