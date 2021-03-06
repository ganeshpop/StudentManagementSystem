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

                switch (choice) {
                    case 1:
                        try {
                            if (studentService.addStudent(StudentInputOutput.createStudent()))
                                System.out.println("Student Created Successfully");
                            else System.out.println("Student Creation failed");
                        } catch (SQLException | IOException | ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                        break;
                    case 2:
                        try {
                            collection = studentService.listStudentsAscending();
                            StudentInputOutput.displayStudents(collection);
                        } catch (SQLException | IOException | ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                        break;
                    case 3:
                        try {
                        collection = studentService.listStudentsDescending();
                        StudentInputOutput.displayStudents(collection);
                        } catch (SQLException | IOException | ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                        break;
                    case 4:
                        try {
                        collection = studentService.getMaxPercentage();
                        StudentInputOutput.displayStudents(collection);
                        } catch (SQLException | IOException | ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                        break;
                    case 5:
                        try {
                        collection = studentService.getMaxMathsScore();
                        StudentInputOutput.displayStudents(collection);
                        } catch (SQLException | IOException | ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                        break;
                    case 6:
                        try {
                        collection = studentService.getMaxMathsAndScienceScore();
                        StudentInputOutput.displayStudents(collection);
                        } catch (SQLException | IOException | ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                        break;
                    case 7:
                        try {
                        System.out.println("Enter Student Roll Number: ");
                        int rollNumber = scanner.nextInt();
                        if (studentService.deleteStudent(rollNumber)) System.out.println("Student with Roll Number " + rollNumber + " is deleted successfully");
                        else System.out.println("Student Not Found!");
                        } catch (SQLException | IOException | ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                        break;
                    case 8:
                        System.out.println("Thanks for using Student Management System!");
                        System.exit(0);
                    default:
                        System.out.println("Invalid Choice Try Again");
                    }
            System.out.println("-----------------------");

            }

        }


