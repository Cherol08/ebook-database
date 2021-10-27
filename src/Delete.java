import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * This class consists of constructor methods that delete a book from the database.
 *
 * @author Cherol Phoshoko
 * @version 16.0.2, 2021-09-24
 */
public class Delete extends Database {

    /**
     * This method deletes book by specified id.
     * <br>
     *
     * @param id Integer contains book id.
     * @throws SQLException if error occurs
     */
    Delete(int id) throws SQLException {
        super();
        rowsChanged = statement.executeUpdate("DELETE FROM books WHERE id=" + id);
        System.out.println("Query complete, " + rowsChanged + " rows deleted.");
        quit();
    }

    /**
     * This method deletes book by specified title.<br>
     *
     * @param title String contains book title or Author.
     * @throws SQLException if error occurs
     */
    Delete(String title) throws SQLException {
        super();
        rowsChanged = statement.executeUpdate("DELETE FROM books WHERE Title= '" + title + "'");
        System.out.println("Query complete, " + rowsChanged + " rows deleted.");
        quit();
    }

    @Override
    void quit() {

    }
}
