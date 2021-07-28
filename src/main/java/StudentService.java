import java.sql.SQLException;
import java.util.Collection;

public class StudentService implements StudentServiceInterface {
    StudentDaoInterface studentDao = new StudentDao();

    public StudentService() throws SQLException, ClassNotFoundException {
    }

    @Override
    public boolean addStudent(Student student) throws SQLException, ClassNotFoundException {
        return studentDao.addStudent(student);

    }

    @Override
    public boolean deleteStudent(int rollNumber) throws SQLException, ClassNotFoundException {
        return studentDao.deleteStudent(rollNumber);

    }

    @Override
    public Collection<Student> listStudentsAscending() throws SQLException, ClassNotFoundException {
        return studentDao.listStudentsAscending();
    }

    @Override
    public Collection<Student> getMaxPercentage() throws SQLException, ClassNotFoundException {
        return studentDao.getMaxPercentage();
    }

    @Override
    public Collection<Student> getMaxMathsScore() throws SQLException, ClassNotFoundException {
        return studentDao.getMaxMathsScore();
    }

    @Override
    public Collection<Student> getMaxMathsAndScienceScore() throws SQLException, ClassNotFoundException {
        return studentDao.getMaxMathsAndScienceScore();
    }

    @Override
    public Collection<Student> listStudentsDescending() throws SQLException, ClassNotFoundException {
        return studentDao.listStudentsDescending();
    }


}
