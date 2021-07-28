import java.sql.SQLException;
import java.util.Collection;

public class StudentService implements StudentServiceInterface{
    StudentDaoInterface studentDao = new StudentDao();

    public StudentService() throws SQLException, ClassNotFoundException {
    }

    @Override
    public boolean addStudent(Student student) {
        return studentDao.addStudent(student);

    }

    @Override
    public boolean deleteStudent(int rollNumber) {
        return studentDao.deleteStudent(rollNumber);

    }

    @Override
    public Collection<Student> listStudentsAscending() {
        return studentDao.listStudentsAscending();
    }

    @Override
    public Collection<Student> getMaxPercentage() {
        return studentDao.getMaxPercentage();
    }

    @Override
    public Collection<Student> getMaxMathsScore() {
        return studentDao.getMaxMathsScore();
    }

    @Override
    public Collection<Student> getMaxMathsAndScienceScore() {
        return studentDao.getMaxMathsAndScienceScore();
    }

    @Override
    public Collection<Student> listStudentsDescending() {
        return studentDao.listStudentsDescending();
    }

    @Override
    public void closeConnection() {
        studentDao.closeConnection();
    }
}
