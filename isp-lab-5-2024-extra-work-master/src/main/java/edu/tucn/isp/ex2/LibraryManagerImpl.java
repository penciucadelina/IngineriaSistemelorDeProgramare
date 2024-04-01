package edu.tucn.isp.ex2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LibraryManagerImpl implements LibraryManager {
    private List<Book> bookCatalog;
    private List<Customer> customers;
    private List<Borrowing> borrowings;

    public LibraryManagerImpl() {
        this.bookCatalog = new ArrayList<>();
        this.customers = new ArrayList<>();
        this.borrowings = new ArrayList<>();
    }

    @Override
    public void addNewBook(Book book, int num) {
        for (int i = 0; i < num; i++) {
            bookCatalog.add(book);
        }
    }

    @Override
    public void addExistingBook(String bookId, int num) {
        // cautam carțile existente in catalog
        Book existingBook = bookCatalog.stream()
                .filter(book -> book.bookId().equals(bookId))
                .findFirst()
                .orElse(null);

        // daca exista o carte cu ID-ul dat
        if (existingBook != null) {
            // Adaugam nr specificat de exemplare
            for (int i = 0; i < num; i++) {
                bookCatalog.add(existingBook);
            }
        } else {
            System.out.println("Cartile cu ID-ul dat nu exista în catalog.");
        }
    }

    @Override
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    @Override
    public void removeCustomer(String customerId) {
        // cautam clientul în lista după ID
        Customer customerToRemove = customers.stream()
                .filter(customer -> customer.customerId().equals(customerId))
                .findFirst()
                .orElse(null);

        // daca gasim clientul, il ștergem
        if (customerToRemove != null) {
            customers.remove(customerToRemove);
            System.out.println("Clientul a fost eliminat cu succes din sistem.");
        } else {
            System.out.println("Nu am găsit un client cu ID-ul dat.");
        }
    }

    public Book searchBookByTitle(String title) {
        //cautam cartea in catalog după titlu
        return bookCatalog.stream()
                .filter(book -> book.title().equalsIgnoreCase(title))
                .findFirst()
                .orElse(null);
    }


    public List<Book> searchBooksByAuthor(String firstName, String lastName) {
        List<Book> foundBooks = new ArrayList<>();

        // cautam cartile in catalog după autor
        for (Book book : bookCatalog) {
            if (book.author().equalsIgnoreCase(firstName) &&
                    book.author().equalsIgnoreCase(lastName)) {
                foundBooks.add(book);
            }
        }

        return foundBooks;
    }

    public void borrowBook(String bookId, String customerId) {
        // cautam cartea în catalog după ID
        Book bookToBorrow = bookCatalog.stream()
                .filter(book -> book.bookId().equals(bookId))
                .findFirst()
                .orElse(null);

        // verificam dacă cartea exista în catalog
        if (bookToBorrow != null) {
            //  un nou împrumut il adaugam la lista
            Borrowing newBorrowing = new Borrowing(customerId, bookId, LocalDate.now(), null, Status.NEW);
            borrowings.add(newBorrowing);
            System.out.println("Cartea a fost împrumutata cu succes.");
        } else {
            System.out.println("Cartea cu ID-ul dat nu exista în catalog.");
        }
    }

    @Override
    public void returnBook(String bookId, String customerId) {
        // cautam imprumutul in lista
        Borrowing borrowingToReturn = borrowings.stream()
                .filter(borrowing -> borrowing.getClientId().equals(customerId) && borrowing.getBookId().equals(bookId))
                .findFirst()
                .orElse(null);

        if (borrowingToReturn != null) {
            //actulizare data de returnare si statusul
            borrowingToReturn = new Borrowing(borrowingToReturn.getClientId(), borrowingToReturn.getBookId(),
                    borrowingToReturn.getReturnDate(), LocalDate.now(), Status.RETURNED);
            System.out.println("Cartea a fost returnata cu succes");
        } else {
            System.out.println("Nu am gasit niciun imprumut");
        }
    }
}