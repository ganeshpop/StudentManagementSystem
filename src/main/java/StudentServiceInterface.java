import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Collection;

public interface StudentServiceInterface {
    boolean addStudent(Student student) throws SQLException, ClassNotFoundException, FileNotFoundException;
    boolean deleteStudent(int rollNumber) throws SQLException, ClassNotFoundException, FileNotFoundException;
    Collection<Student>  listStudentsAscending() throws SQLException, ClassNotFoundException, FileNotFoundException;
    Collection<Student>  getMaxPercentage() throws SQLException, ClassNotFoundException, FileNotFoundException;
    Collection<Student>  getMaxMathsScore() throws SQLException, ClassNotFoundException, FileNotFoundException;
    Collection<Student>  getMaxMathsAndScienceScore() throws SQLException, ClassNotFoundException, FileNotFoundException;
    Collection<Student>  listStudentsDescending() throws SQLException, ClassNotFoundException, FileNotFoundException;

}
