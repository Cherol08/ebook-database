import java.sql.SQLException;

/**
 * This class consists of methods used to update details about the books
 * in the database.
 *
 * @author Cherol Phoshoko
 * @version 16.0.2, 2021-09-24
 */
public class Update extends Database {

    /**
     * Update Constructor.
     *
     * @throws SQLException if error occurs.
     */
    Update() throws SQLException {
        super();
    }

    /**
     * This method updates the book id.<br>
     *
     * @param id    Integer contains the book id.
     * @param newId Integer contains the new book id.
     * @throws SQLException if error occurs.
     */
    void setId(int id, int newId) throws SQLException {
        rowsChanged = statement.executeUpdate("UPDATE books SET id=" + newId + " WHERE id=" + id);
        System.out.println("Query complete, " + rowsChanged + " rows changed.");
        quit();
    }

    /**
     * @param id    Integer contains the book id.
     * @param title String contains new book title.
     * @throws SQLException if error occurs.
     */
    void setTitle(int id, String title) throws SQLException {
        rowsChanged = statement.executeUpdate("UPDATE books SET Title=" + "\"" + title + "\"" + " WHERE id=" + id);
        System.out.println("Query complete, " + rowsChanged + " rows changed.");
        quit();

    }

    /**
     * @param id     Integer contains the book id.
     * @param author String contains new book author.
     * @throws SQLException if error occurs.
     */
    void setAuthor(int id, String author) throws SQLException {
        rowsChanged = statement.executeUpdate("UPDATE books SET Author=" + "\"" + author + "\"" + " WHERE id=" + id);
        System.out.println("Query complete, " + rowsChanged + " rows changed.");
        quit();

    }

    /**
     * @param id  Integer contains the book id.
     * @param qty Integer contains the new book quantity.
     * @throws SQLException if error occurs
     */
    void setQty(int id, int qty) throws SQLException {
        rowsChanged = statement.executeUpdate("UPDATE books SET Qty=" + qty + " WHERE id=" + id);
        System.out.println("Query complete, " + rowsChanged + " rows changed.");
        quit();


    }

    @Override
    void quit() {

    }

}
