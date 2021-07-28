import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

public class StudentService implements StudentServiceInterface {
    StudentDaoInterface studentDao = new StudentDao();

    public StudentService() throws SQLException, ClassNotFoundException {
    }

    @Override
    public boolean addStudent(Student student) throws SQLException, ClassNotFoundException, IOException {
        return studentDao.addStudent(student);

    }

    @Override
    public boolean deleteStudent(int rollNumber) throws SQLException, ClassNotFoundException, IOException {
        return studentDao.deleteStudent(rollNumber);

    }

    @Override
    public Collection<Student> listStudentsAscending() throws SQLException, ClassNotFoundException, IOException {
        return studentDao.listStudentsAscending();
    }

    @Override
    public Collection<Student> getMaxPercentage() throws SQLException, ClassNotFoundException, IOException {
        return studentDao.getMaxPercentage();
    }

    @Override
    public Collection<Student> getMaxMathsScore() throws SQLException, ClassNotFoundException, IOException {
        return studentDao.getMaxMathsScore();
    }

    @Override
    public Collection<Student> getMaxMathsAndScienceScore() throws SQLException, ClassNotFoundException, IOException {
        return studentDao.getMaxMathsAndScienceScore();
    }

    @Override
    public Collection<Student> listStudentsDescending() throws SQLException, ClassNotFoundException, IOException {
        return studentDao.listStudentsDescending();
    }


}
