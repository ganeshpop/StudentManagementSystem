import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("java.sql.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/students","ganesh","password");
        connection.setAutoCommit(false);
        return connection;
    }

}
