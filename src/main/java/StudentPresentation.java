import java.io.IOException;
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
                    if (studentService.addStudent(StudentInputOutput.createStudent()))
                        System.out.println("Student Created Successfully");
                    else System.out.println("Student Creation failed");
                    break;
                }
                case 2:
                    collection = studentService.listStudentsAscending();
                    StudentInputOutput.displayStudents(collection);
                    break;
                case 3:
                    collection = studentService.listStudentsDescending();
                    StudentInputOutput.displayStudents(collection);
                    break;
                case 4:
                    collection = studentService.getMaxPercentage();
                    StudentInputOutput.displayStudents(collection);
                    break;
                case 5:
                    collection = studentService.getMaxMathsScore();
                    StudentInputOutput.displayStudents(collection);
                    break;
                case 6:
                    collection = studentService.getMaxMathsAndScienceScore();
                    StudentInputOutput.displayStudents(collection);
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
        } catch (SQLException | ClassNotFoundException | IOException e){
                e.printStackTrace();

            }

        }


}


