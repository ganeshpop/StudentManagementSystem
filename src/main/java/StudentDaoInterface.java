import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

public interface StudentDaoInterface {
    boolean addStudent(Student student) throws SQLException, ClassNotFoundException;
    boolean deleteStudent(int rollNumber) throws SQLException, ClassNotFoundException;
    Collection<Student>  listStudentsAscending() throws SQLException, ClassNotFoundException;
    Collection<Student>  getMaxPercentage() throws SQLException, ClassNotFoundException;
    Collection<Student>  getMaxMathsScore() throws SQLException, ClassNotFoundException;
    Collection<Student>  getMaxMathsAndScienceScore() throws SQLException, ClassNotFoundException;
    Collection<Student>  listStudentsDescending() throws SQLException, ClassNotFoundException;

}
