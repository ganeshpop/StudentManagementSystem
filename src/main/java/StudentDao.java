import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class StudentDao implements StudentDaoInterface {

    @Override
    public boolean addStudent(Student student) throws SQLException, ClassNotFoundException, IOException {
        Connection connection = MySQLConnection.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO students(student_name,english,maths,science,total_score) VALUE(?,?,?,?,?)");
            preparedStatement.setString(1,student.getStudentName());
            preparedStatement.setInt(2,student.getMarksInEnglish());
            preparedStatement.setInt(3,student.getMarksInMaths());
            preparedStatement.setInt(4,student.getMarksInScience());
            preparedStatement.setInt(5,(student.getMarksInMaths() + student.getMarksInMaths() + student.getMarksInScience()));
            int affectedRows = preparedStatement.executeUpdate();
            connection.commit();
            connection.close();
            return affectedRows > 0;
    }

    @Override
    public boolean deleteStudent(int rollNumber) throws SQLException, ClassNotFoundException, IOException {
        Connection connection = MySQLConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM students WHERE roll_number = ?");
            preparedStatement.setInt(1, rollNumber);
            int affectedRows = preparedStatement.executeUpdate();
            connection.commit();
        return affectedRows > 0;
    }



    @Override
    public Collection<Student> listStudentsAscending() throws SQLException, ClassNotFoundException, IOException {
        Collection<Student> students = new ArrayList<>();
        Connection connection = MySQLConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM students ORDER BY roll_number ASC");
        ResultSet resultSet = preparedStatement.executeQuery();
        generateStudents(students, resultSet);
        return students;
    }

    @Override
    public Collection<Student> getMaxPercentage() throws SQLException, ClassNotFoundException, IOException {
        Collection<Student> students = new ArrayList<>();
        Connection connection = MySQLConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM students where (total_score * 100 / 300) = (SELECT MAX(total_score * 100 / 300) FROM students);");
        ResultSet resultSet = preparedStatement.executeQuery();
        generateStudents(students, resultSet);
        return students;
    }

    @Override
    public Collection<Student> getMaxMathsScore() throws SQLException, ClassNotFoundException, IOException {
        Collection<Student> students = new ArrayList<>();
        Connection connection = MySQLConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM students where maths = (SELECT MAX(maths) FROM students);");
        ResultSet resultSet = preparedStatement.executeQuery();
        generateStudents(students, resultSet);
        return students;
    }

    @Override
    public Collection<Student> getMaxMathsAndScienceScore() throws SQLException, ClassNotFoundException, IOException {
        Collection<Student> students = new ArrayList<>();
        Connection connection = MySQLConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM students where maths + science = (SELECT MAX(maths) + MAX(Science) FROM students);");
        ResultSet resultSet = preparedStatement.executeQuery();
        generateStudents(students, resultSet);
        return students;
    }


    @Override
    public Collection<Student> listStudentsDescending() throws SQLException, ClassNotFoundException, IOException {
        Collection<Student> students = new ArrayList<>();
        Connection connection = MySQLConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM students ORDER BY roll_number DESC");
        ResultSet resultSet = preparedStatement.executeQuery();
        generateStudents(students, resultSet);
        return students;
    }

    private void generateStudents(Collection<Student> students, ResultSet resultSet) throws SQLException {
        while(resultSet.next()){
            int rollNumber = resultSet.getInt("roll_number");
            String studentName = resultSet.getString("student_name");
            int marksInEnglish = resultSet.getInt("english");
            int marksInMaths  = resultSet.getInt("maths");
            int marksInScience = resultSet.getInt("science");
            students.add(new Student(rollNumber,studentName,marksInEnglish,marksInMaths,marksInScience));
        }
    }
}
