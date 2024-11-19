import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Book {
    private String title;
    private String author;
    private String isbn;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }


    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }


    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", ISBN: " + isbn;
    }
}


class LibraryCatalog {
    private List<Book> books;


    public LibraryCatalog() {
        books = new ArrayList<>();
    }

  
    public void addBook(Book book) {
        books.add(book);
    }

   
    public List<Book> searchByTitle(String title) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                result.add(book);
            }
        }
        return result;
    }

    
    public List<Book> searchByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().toLowerCase().contains(author.toLowerCase())) {
                result.add(book);
            }
        }
        return result;
    }


    public List<Book> searchByIsbn(String isbn) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                result.add(book);
            }
        }
        return result;
    }


    public void displayAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available in the catalog.");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }
}


public class Main {

    public static void main(String[] args) {
      
        LibraryCatalog catalog = new LibraryCatalog();

      
        catalog.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald", "9780743273565"));
        catalog.addBook(new Book("1984", "George Orwell", "9780451524935"));
        catalog.addBook(new Book("To Kill a Mockingbird", "Harper Lee", "9780061120084"));
        catalog.addBook(new Book("The Catcher in the Rye", "J.D. Salinger", "9780316769488"));

      
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nLibrary Catalog Search");
            System.out.println("1. Search by Title");
            System.out.println("2. Search by Author");
            System.out.println("3. Search by ISBN");
            System.out.println("4. Display All Books");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); 

            switch (option) {
                case 1:
                    System.out.print("Enter title to search: ");
                    String title = scanner.nextLine();
                    List<Book> titleResults = catalog.searchByTitle(title);
                    if (titleResults.isEmpty()) {
                        System.out.println("No books found with that title.");
                    } else {
                        titleResults.forEach(System.out::println);
                    }
                    break;

                case 2:
                    System.out.print("Enter author to search: ");
                    String author = scanner.nextLine();
                    List<Book> authorResults = catalog.searchByAuthor(author);
                    if (authorResults.isEmpty()) {
                        System.out.println("No books found by that author.");
                    } else {
                        authorResults.forEach(System.out::println);
                    }
                    break;

                case 3:
                    System.out.print("Enter ISBN to search: ");
                    String isbn = scanner.nextLine();
                    List<Book> isbnResults = catalog.searchByIsbn(isbn);
                    if (isbnResults.isEmpty()) {
                        System.out.println("No books found with that ISBN.");
                    } else {
                        isbnResults.forEach(System.out::println);
                    }
                    break;

                case 4:
                    System.out.println("\nAll Books in Catalog:");
                    catalog.displayAllBooks();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }
}
