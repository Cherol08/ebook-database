import java.sql.*;

/**
 * This abstract class allows access to the ebook's database by creating a constructor to access it
 * and a method to close it which other classes will inherit.
 *
 * @author Cherol Phoshoko
 * @version 16.0.2, 2021-09-24
 */
public abstract class Database {

    Connection connection;
    Statement statement;
    ResultSet results;
    int rowsChanged;

    /**
     * This constructor creates access to the database
     *
     * @throws SQLException if error occurs
     */
    Database() throws SQLException {
        //connection creates a connection to the ebooks database and statement, uses connection to help
        // run commands.
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookstore_db?useSSL=false",
                "username", "password");
        statement = connection.createStatement();

    }

    /**
     * Closes the database and all connections to it.
     *
     * @throws SQLException if error occurs
     */
    void quit() throws SQLException {
        results.close();
        statement.close();
        connection.close();
    }

}
