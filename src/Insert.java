import java.sql.SQLException;

/**
 * This class consists of methods to insert books into the database.
 *
 * @author Cherol Phoshoko
 * @version 16.0.2, 2021-09-24
 */
public class Insert extends Database {

    /**
     * @param id     Integer contains book id.
     * @param Title  String contains book title.
     * @param Author String contains book author.
     * @param Qty    Integer contains book quantity.
     * @throws SQLException if error occurs
     */
    Insert(int id, String Title, String Author, int Qty) throws SQLException {
        super();
        rowsChanged = statement.executeUpdate("INSERT INTO books VALUES (" + id + ", '" + Title + "', '" + Author + "'" + ", " + Qty + ")");
        System.out.println("Query complete, " + rowsChanged + " rows added.");
        quit();

    }

    @Override
    void quit() {

    }
}
