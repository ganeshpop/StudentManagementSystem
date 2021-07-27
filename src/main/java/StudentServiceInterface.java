import java.sql.SQLException;
import java.util.Collection;

public interface StudentServiceInterface {
    boolean addStudent(Student student);
    boolean deleteStudent(int rollNumber);
    Collection<Student>  listStudentsAscending();
    Collection<Student>  getMaxPercentage();
    Collection<Student>  getMaxMathsScore();
    Collection<Student>  getMaxMathsAndScienceScore();
    Collection<Student>  listStudentsDescending();
    void closeConnection();

}
