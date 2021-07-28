import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

public interface StudentDaoInterface {
    boolean addStudent(Student student) throws SQLException, ClassNotFoundException, IOException;
    boolean deleteStudent(int rollNumber) throws SQLException, ClassNotFoundException, IOException;
    Collection<Student>  listStudentsAscending() throws SQLException, ClassNotFoundException, IOException;
    Collection<Student>  getMaxPercentage() throws SQLException, ClassNotFoundException, IOException;
    Collection<Student>  getMaxMathsScore() throws SQLException, ClassNotFoundException, IOException;
    Collection<Student>  getMaxMathsAndScienceScore() throws SQLException, ClassNotFoundException, IOException;
    Collection<Student>  listStudentsDescending() throws SQLException, ClassNotFoundException, IOException;

}
