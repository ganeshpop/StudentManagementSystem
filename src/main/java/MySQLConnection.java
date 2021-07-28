import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MySQLConnection {
    public static Connection getConnection() throws ClassNotFoundException, SQLException, FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("DbConnection.properties");
        Properties properties = new Properties();
        Class.forName(properties.getProperty("DB.DRIVER_CLASS_NAME"));
        Connection connection = DriverManager.getConnection(properties.getProperty("DB.URL"), properties.getProperty("DB.USER_NAME"), properties.getProperty("DB.PASSWORD"));
        connection.setAutoCommit(false);
        return connection;
    }

}
