import java.util.Collection;
import java.util.Scanner;

public class StudentInputOutput {
    static Scanner scanner = new Scanner(System.in);

    public static void displayStudents(Collection<Student> collection){
        if (collection.size() == 0) {
            System.out.println("No Students Retrieved");
        } else {
            for (Student student : collection) {
                System.out.println("-----------------------");
                System.out.println("Roll Number: " + student.getRollNumber() + "\nName: "
                                    + student.getStudentName() + "\n---Marks---\nEnglish: " + student.getMarksInEnglish()
                                    +  "\nMaths: " + student.getMarksInMaths() + "\nScience: " + student.getMarksInScience());
            }
        }
    }

    public static Student createStudent(){
        String name;
        while (true) {
            System.out.println("Enter Student Name: ");
            name = scanner.nextLine();
            if(name.length() > 0) break;
            else System.out.println("Invalid Name");
        }
        System.out.println("Enter English Score: ");
        int englishScore = getScore();
        System.out.println("Enter Maths Score: ");
        int mathsScore =  getScore();
        System.out.println("Enter Science Score: ");
        int scienceScore =  getScore();
        return new Student(englishScore, mathsScore, scienceScore, name);
    }

    private static int getScore(){
        while (true) {
            String userInput = scanner.nextLine();
            if(userInput.matches("[0-9]+") ) {
                int intUserInput = Integer.parseInt(userInput);
                if(intUserInput <= 100) return intUserInput;
                else System.out.println("Maximum Score Allowed is 100");
            } else System.out.println("Only Integers Allowed Try Again ");
        }
    }


}
