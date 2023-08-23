
import java.util.List;
import java.util.Scanner;

public class BookShopApp {
    public static void main(String[] args) {
        BookInventory inventory = new BookInventory();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n----- Book Shop Inventory -----");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Search by ISBN");
            System.out.println("4. Search by Author");
            System.out.println("5. Display Inventory");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter book ISBN: ");
                    String isbn = scanner.nextLine();
                    System.out.print("Enter book price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Enter book quantity: ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character

                    Book newBook = new Book(title, author, isbn, price, quantity);
                    inventory.addBook(newBook);
                    System.out.println("Book added to inventory.");
                    break;

                case 2:
                    System.out.print("Enter the ISBN of the book to remove: ");
                    String isbnToRemove = scanner.nextLine();
                    Book bookToRemove = inventory.searchByISBN(isbnToRemove);
                    if (bookToRemove != null) {
                        inventory.removeBook(bookToRemove);
                        System.out.println("Book removed from inventory.");
                    } else {
                        System.out.println("Book not found in inventory.");
                    }
                    break;

                case 3:
                    System.out.print("Enter the ISBN to search: ");
                    String isbnToSearch = scanner.nextLine();
                    Book foundBook = inventory.searchByISBN(isbnToSearch);
                    if (foundBook != null) {
                        System.out.println("Book found in inventory:");
                        System.out.println(foundBook.toString());
                    } else {
                        System.out.println("Book not found in inventory.");
                    }
                    break;

                case 4:
                    System.out.print("Enter the author name to search: ");
                    String authorToSearch = scanner.nextLine();
                    List<Book> booksByAuthor = inventory.searchByAuthor(authorToSearch);
                    if (!booksByAuthor.isEmpty()) {
                        System.out.println("Books by " + authorToSearch + " found in inventory:");
                        for (Book book : booksByAuthor) {
                            System.out.println(book.getTitle());
                        }
                    } else {
                        System.out.println("No books found by " + authorToSearch + " in inventory.");
                    }
                    break;

                case 5:
                    inventory.displayInventory();
                    break;

                case 0:
                    System.out.println("Exiting the Book Shop Inventory.");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

}

