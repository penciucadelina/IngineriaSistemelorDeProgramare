package edu.tucn.isp.ex2;

import java.util.List;

interface LibraryManager {
    void addNewBook(Book book, int num);

    void addExistingBook(String bookId, int num);

    void addCustomer(Customer customer);

    void removeCustomer(String customerId);

    Book searchBookByTitle(String title);

    List<Book> searchBooksByAuthor(String firstName, String lastName);

    void borrowBook(String bookId, String customerId);

    void returnBook(String bookId, String customerId);
}