
import java.sql.SQLException;
/**
 * This class consists of methods used to search the database for books.
 * 
 * @author Cherol Phoshoko
 * @version 16.0.2, 2021-09-24
 */
public class Search extends Database {
	Search() throws SQLException{
		super();
	}

	/**
	 * Searches books by book id.
	 * <br>
	 * @param id Integer of the book id
	 * @throws SQLException if error occurs
	 */
	void byId(int id) throws SQLException {
        results = statement.executeQuery("SELECT * FROM books WHERE id= '" + id + "'");
        // Loop over the results, printing them all.
        while (results.next()) {
            System.out.println(results.getInt("id") + ", "
                    + results.getString("Title") + ", "
                    + results.getString("Author") + ", "        
                    + results.getInt("Qty"));
        }
        quit();
	}
	
	/**
	 * Searches books by book title.
	 * <br>
	 * @param title String contains book title.
	 * @throws SQLException if error occurs
	 */
	void byTitle(String title) throws SQLException {
		// SELECT command returns the book information and stores it in results.
        results = statement.executeQuery("SELECT * FROM books WHERE Title= " + "\"" + title + "\"");
        // Loops over the results and prints the information
        while (results.next()) {
            System.out.println(results.getInt("id") + ", "
                    + results.getString("Title") + ", "
                    + results.getString("Author") + ", "        
                    + results.getInt("Qty"));
        }
        quit();
	}


	/**
	 * Searches books by book author.
	 * <br>
	 * @param author String contains book author
	 * @throws SQLException if error occurs
	 */
	void byAuthor(String author) throws SQLException {
        results = statement.executeQuery("SELECT * FROM books WHERE Author= " + "\"" + author + "\"");
        while (results.next()) {
            System.out.println(results.getInt("id") + ", "
                    + results.getString("Title") + ", "
                    + results.getString("Author") + ", "        
                    + results.getInt("Qty"));
        }
        quit();
	}

	@Override
	void quit() {
		 
	}
}
