package Worksheet.A9ChainedExceptionDemo.Repository;
import java.sql.SQLException;

public class UserRepository {
    public String fetchUserById(int id) throws SQLException {
        throw new SQLException("Database connection failed for ID: " + id);
    }
}
