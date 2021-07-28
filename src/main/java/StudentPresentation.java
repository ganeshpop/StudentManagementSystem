import java.sql.SQLException;
import java.util.Collection;
import java.util.Scanner;

public class StudentPresentation implements StudentPresentationInterface{
        public StudentServiceInterface studentService;
        Scanner scanner = new Scanner(System.in);
    {
        try {
            studentService = new StudentService();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
        public void showMenu() {
            System.out.println("1. Add Student");
            System.out.println("2. List All Students in Ascending Order");
            System.out.println("3. List All Students in Descending Order");
            System.out.println("4. List Student/Students with Highest Percentage");
            System.out.println("5. List Student/Students with Highest Maths Score");
            System.out.println("6. List Student/Students with Highest Maths and Science Score Combined");
            System.out.println("7. Delete Student");
            System.out.println("8. Exit");

        }

        @Override
        public void performMenu(int choice) {
            Collection<Student> collection;
            try {
            switch (choice) {
                case 1: {
                    System.out.println("Enter Student Name: ");
                    String name = scanner.nextLine();
                    System.out.println("Enter English Score: ");
                    int englishScore = getScore();
                    System.out.println("Enter Maths Score: ");
                    int mathsScore =  getScore();
                    System.out.println("Enter Science Score: ");
                    int scienceScore =  getScore();
                    if (studentService.                                                                                                           addStudent(new Student(name,englishScore,mathsScore,scienceScore)))
                        System.out.println("Student Created Successfully");
                    else System.out.println("Student Creation failed");
                    break;
                }
                case 2:
                    collection = studentService.listStudentsAscending();
                    if (collection.size() == 0) {
                        System.out.println("No Students");
                        break;
                    }
                    for (Student student : collection) {
                        System.out.println("-----------------------");
                        System.out.println(student);
                        System.out.println("-----------------------");
                    }
                    break;
                case 3:
                    collection = studentService.listStudentsDescending();
                    if (collection.size() == 0) {
                        System.out.println("No Students");
                        break;
                    }
                    for (Student student : collection) {
                        System.out.println("-----------------------");
                        System.out.println(student);
                        System.out.println("-----------------------");
                    }
                    break;
                case 4:
                    collection = studentService.getMaxPercentage();
                    if (collection.size() == 0) {
                        System.out.println("No Students");
                        break;
                    }
                    for (Student student : collection) {
                        System.out.println("-----------------------");
                        System.out.println(student);
                        System.out.println("-----------------------");
                    }
                    break;
                case 5:
                    collection = studentService.getMaxMathsScore();
                    if (collection.size() == 0) {
                        System.out.println("No Students");
                        break;
                    }
                    for (Student student : collection) {
                        System.out.println("-----------------------");
                        System.out.println(student);
                        System.out.println("-----------------------");
                    }
                    break;
                case 6:
                    collection = studentService.getMaxMathsAndScienceScore();
                    if (collection.size() == 0) {
                        System.out.println("No Students");
                        break;
                    }
                    for (Student student : collection) {
                        System.out.println("-----------------------");
                        System.out.println(student);
                        System.out.println("-----------------------");
                    }
                    break;
                case 7:
                    System.out.println("Enter Student Roll Number: ");
                    int rollNumber = scanner.nextInt();
                    if (studentService.deleteStudent(rollNumber)) System.out.println("Student with Roll Number " + rollNumber + " is deleted successfully");
                    else System.out.println("Student Not Found!");
                    break;
                case 8:
                    System.out.println("Thanks for using Student Management System!");
                    System.exit(0);
                default:
                    System.out.println("Invalid Choice Try Again");
            }
        } catch (SQLException | ClassNotFoundException e){
                e.printStackTrace();

            }

        }
        private int getScore(){
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


