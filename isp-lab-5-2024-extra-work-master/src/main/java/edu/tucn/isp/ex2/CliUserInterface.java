package edu.tucn.isp.ex2;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class CliUserInterface {
    private LibraryManager manager;

    public CliUserInterface(LibraryManager manager) {
        this.manager = manager;
    }

    public void addNewBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter book details:");
        System.out.print("Book ID: ");
        String bookId = scanner.nextLine();
        System.out.print("Title: ");
        String title = scanner.nextLine();
        System.out.print("Author first name: ");
        String authorFirstName = scanner.nextLine();
        System.out.print("Author last name: ");
        String authorLastName = scanner.nextLine();
        System.out.print("Publication date (YYYY-MM-DD): ");
        String publicationDateStr = scanner.nextLine();
        LocalDate publicationDate = LocalDate.parse(publicationDateStr);
        System.out.print("Publisher name: ");
        String publisherName = scanner.nextLine();
        System.out.print("Publisher location: ");
        String publisherLocation = scanner.nextLine();
        System.out.print("Publisher contact info: ");
        String publisherContactInfo = scanner.nextLine();
        System.out.print("Genre (ADVENTURE, MYSTERY, FANTASY, HISTORY, HORROR, HUMOUR): ");
        String genreStr = scanner.nextLine();
        BookGenre genre = BookGenre.valueOf(genreStr.toUpperCase());
        System.out.print("Number of pages: ");
        int numOfPages = scanner.nextInt();
        System.out.print("Number of copies to add: ");
        int num = scanner.nextInt();
        scanner.nextLine();

        Publisher publisher = new Publisher(publisherName, publisherLocation, publisherContactInfo);
        Author author = new Author(authorFirstName, authorLastName, publicationDate);
        Book book = new Book(bookId, title, author, publicationDate, publisher, genre, numOfPages);

        manager.addNewBook(book, num);

    }

    public void addExistingBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter book ID: ");
        String bookId = scanner.nextLine();
        System.out.print("Enter number of copies to add: ");
        int num = scanner.nextInt();
        scanner.nextLine();

        manager.addExistingBook(bookId, num);

    }

    public void addCustomer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter customer details:");
        System.out.print("Customer ID: ");
        String customerId = scanner.nextLine();
        System.out.print("First name: ");
        String firstName = scanner.nextLine();
        System.out.print("Last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Phone: ");
        String phone = scanner.nextLine();

        Customer customer = new Customer(customerId, firstName, lastName, email, phone);
        manager.addCustomer(customer);

    }

    public void removeCustomer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter customer ID: ");
        String customerId = scanner.nextLine();

        manager.removeCustomer(customerId);

    }

    public void searchBookByTitle() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();

        Book book = manager.searchBookByTitle(title);
        if (book != null) {
            System.out.println("Book found:");
            System.out.println(book);
        } else {
            System.out.println("Book not found.");
        }

    }

    public void searchBookByAuthor() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter author's first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter author's last name: ");
        String lastName = scanner.nextLine();

        List<Book> books = manager.searchBooksByAuthor(firstName, lastName);
        if (!books.isEmpty()) {
            System.out.println("Books found:");
            for (Book book : books) {
                System.out.println(book);
            }
        } else {
            System.out.println("No books found for the author.");
        }

    }

    public void borrowBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter book ID: ");
        String bookId = scanner.nextLine();
        System.out.print("Enter customer ID: ");
        String customerId = scanner.nextLine();

        manager.borrowBook(bookId, customerId);

    }

    public void returnBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter book ID: ");
        String bookId = scanner.nextLine();
        System.out.print("Enter customer ID: ");
        String customerId = scanner.nextLine();

        manager.returnBook(bookId, customerId);

    }
}
