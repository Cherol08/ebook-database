import java.sql.SQLException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * This java program manages a library of ebooks in a database.
 *
 * @author Cherol Phoshoko
 * @version 16.0.2, 2021-09-24
 */
public class Main {
    /**
     * Main method of this program is used to access the database, adding new books
     * to it, update info about existing books or deleting them from the database
     * entirely. User can also search for books they want to find in the
     * database.<br>
     *
     * @param args The command line arguments
     * @throws SQLException if error occurs
     */
    public static void main(String[] args) throws SQLException {
        int option;
        int id, qty;
        String title, author;

        Scanner input = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("""
                        \nChoose option:
                        1. Enter book
                        2. Update book
                        3. Delete book
                        4. Search books
                        0. Exit""");
                option = input.nextInt();

                if (option == 1) {
                    input.nextLine();
                    while (true) {
                        try {
                            System.out.println("\nEnter book id:");
                            id = input.nextInt();
                            input.nextLine();
                            System.out.println("Enter book title:");
                            title = input.nextLine();
                            System.out.println("Enter book author:");
                            author = input.nextLine();
                            System.out.println("Enter book(s) quantity:");
                            qty = input.nextInt();
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input, Please re-enter details");
                            input.nextLine();
                        }
                    }
                    // method takes new book information and adds it to the database
                    new Insert(id, toTitleCase(title), toTitleCase(author), qty);

                } else if (option == 2) {
                    int choice;
                    Update newBook = new Update();
                    while (true) {
                        System.out.println("""
                                \nChoose detail to Update:
                                1 - Book Id
                                2 - Book Title
                                3 - Book Author
                                4 - Book Quantity
                                0 - Return to main menu""");
                        choice = input.nextInt();

                        if (choice == 1) {
                            int newId;
                            while (true) {
                                try {
                                    System.out.println("\nEnter old book id:");
                                    id = input.nextInt();
                                    System.out.println("Enter new book id:");
                                    newId = input.nextInt();
                                    break;
                                } catch (InputMismatchException e) {
                                    System.out.println("Invalid input, Please re-enter details");
                                    input.nextLine();
                                }
                            }
                            // updates book id
                            newBook.setId(id, newId);

                        } else if (choice == 2) {
                            System.out.println("\nEnter book id:");
                            id = input.nextInt();
                            System.out.println("Enter new book title:");
                            input.nextLine();
                            String newTitle = input.nextLine();

                            // updates book title
                            newBook.setTitle(id, toTitleCase(newTitle));

                        } else if (choice == 3) {
                            System.out.println("\nEnter book id:");
                            id = input.nextInt();
                            System.out.println("Enter new author name:");
                            input.nextLine();
                            String newAuthor = input.nextLine();
                            // updates book author
                            newBook.setAuthor(id, toTitleCase(newAuthor));

                        } else if (choice == 4) {
                            int newQty;
                            while (true) {
                                try {
                                    System.out.println("\nEnter book id:");
                                    id = input.nextInt();
                                    System.out.println("Enter new quantity:");
                                    newQty = input.nextInt();
                                    break;
                                } catch (InputMismatchException e) {
                                    System.out.println("Invalid input, Please re-enter details");
                                    input.nextLine();
                                }
                            }
                            // updates book quantity
                            newBook.setQty(id, newQty);

                        } else if (choice == 0) {
                            break;
                        } else {
                            System.out.println("\nInvalid option, Try again!");
                        }
                    }

                } else if (option == 3) {
                    input.nextLine();
                    System.out.println("\nEnter id or title of book to delete:");
                    String bookDetail = input.nextLine();
                    // if-else checks if input is book id or title
                    if (Character.isDigit(bookDetail.length())) {
                        int bookId = Integer.parseInt(bookDetail);
                        new Delete(bookId);
                    } else {
                        new Delete(bookDetail);
                    }
                } else if (option == 4) {
                    Search search = new Search();
                    System.out.println("\nChoose search by method:\n1 - Id\n2 - Title\n3 - Author");
                    int choice = input.nextInt();

                    if (choice == 1) {
                        while (true) {
                            try {
                                System.out.println("\nEnter book Id for search:");
                                int bookDetail = input.nextInt();
                                // searches book by id
                                search.byId(bookDetail);
                                break;
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid input, Please re-enter details");
                                input.nextLine();
                            }
                        }
                    } else if (choice == 2) {
                        System.out.println("\nEnter book title for search:");
                        input.nextLine();
                        String bookDetail = input.nextLine();
                        // searches book by title
                        search.byTitle(toTitleCase(bookDetail));
                    } else if (choice == 3) {
                        input.nextLine();
                        System.out.println("\nEnter book author for search:");
                        String bookDetail = input.nextLine();
                        // searches book by author
                        search.byAuthor(toTitleCase(bookDetail));
                    } else {
                        System.out.println("\nInvalid option, Try again!");
                    }

                } else if (option == 0) {
                    System.out.println("\nLogout Successful");
                    break;

                } else {
                    System.out.println("\nInvalid option, Try again!");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid option, Try again!");
                input.nextLine();
            }
        }
    }

    /**
     * This recursive method is used to convert strings to title case. <br>
     *
     * @param string is the string to be converted to title case.
     * @return returns the formatted string.
     */

    public static String toTitleCase(String string) {
        String word_separator = " ";
        if (string == null || string.isEmpty()) {
            return string;
        }
        // this splits string at space and converts each 1st character of substring to
        // title case and following characters to lower case
        return Arrays.stream(string.split(word_separator)).map(
                        word -> word.isEmpty() ? word : Character.toTitleCase(word.charAt(0)) + word.substring(1).toLowerCase())
                .collect(Collectors.joining(word_separator));
    }
}
