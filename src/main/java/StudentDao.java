import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class StudentDao implements StudentDaoInterface {
    Connection createConnection() throws ClassNotFoundException, SQLException {
        Class.forName("java.sql.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/students","ganesh","password");
        connection.setAutoCommit(false);
        return connection;
    }
    @Override
    public boolean addStudent(Student student) throws SQLException, ClassNotFoundException {
        Connection connection = createConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO students(student_name,english,maths,science,total_score) VALUE(?,?,?,?,?)");
            preparedStatement.setString(1,student.getStudentName());
            preparedStatement.setInt(2,student.getMarksInEnglish());
            preparedStatement.setInt(3,student.getMarksInMaths());
            preparedStatement.setInt(4,student.getMarksInScience());
            preparedStatement.setInt(5,(student.getMarksInMaths() + student.getMarksInMaths() + student.getMarksInScience()));
            int affectedRows = preparedStatement.executeUpdate();
            if(affectedRows > 0) {
                connection.commit();
                return true;
            }
        } catch (SQLException e) {
            connection.rollback();
            e.printStackTrace();
        } finally {
            connection.close();
        }
        return false;
    }

    @Override
    public boolean deleteStudent(int rollNumber) throws SQLException, ClassNotFoundException {
        Connection connection = createConnection();
        try {
            connection.commit();
            PreparedStatement preparedStatement = createConnection().prepareStatement("DELETE FROM students WHERE roll_number = ?");
            preparedStatement.setInt(1, rollNumber);
            int affectedRows = preparedStatement.executeUpdate();
            System.out.println("---------Before Commit------------");
            System.out.println("---------After Commit------------");
            if (affectedRows > 0) {
                return true;
            }
        } catch (SQLException | ClassNotFoundException e) {
            connection.rollback();
            e.printStackTrace();
        } finally {
            connection.close();
        }
        return false;
    }



    @Override
    public Collection<Student> listStudentsAscending() throws SQLException, ClassNotFoundException {
        Collection<Student> students = new ArrayList<>();
        Connection connection =  createConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM students ORDER BY roll_number ASC");
            ResultSet resultSet = preparedStatement.executeQuery();
            generateStudents(students, resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
        return students;
    }

    @Override
    public Collection<Student> getMaxPercentage() throws SQLException, ClassNotFoundException {
        Collection<Student> students = new ArrayList<>();
        Connection connection =  createConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM students where (total_score * 100 / 300) = (SELECT MAX(total_score * 100 / 300) FROM students);");
            ResultSet resultSet = preparedStatement.executeQuery();
            generateStudents(students, resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public Collection<Student> getMaxMathsScore() throws SQLException, ClassNotFoundException {
        Collection<Student> students = new ArrayList<>();
        Connection connection =  createConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM students where maths = (SELECT MAX(maths) FROM students);");
            ResultSet resultSet = preparedStatement.executeQuery();
            generateStudents(students, resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
        return students;
    }

    @Override
    public Collection<Student> getMaxMathsAndScienceScore() throws SQLException, ClassNotFoundException {
        Collection<Student> students = new ArrayList<>();
        Connection connection =  createConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM students where maths + science = (SELECT MAX(maths) + MAX(Science) FROM students);");
            ResultSet resultSet = preparedStatement.executeQuery();
            generateStudents(students, resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
        return students;
    }


    @Override
    public Collection<Student> listStudentsDescending() throws SQLException, ClassNotFoundException {
        Collection<Student> students = new ArrayList<>();
        Connection connection =  createConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM students ORDER BY roll_number DESC");
            ResultSet resultSet = preparedStatement.executeQuery();
            generateStudents(students, resultSet);
        } catch (SQLException  e) {
            e.printStackTrace();
        } finally {
           connection.close();
        }

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
