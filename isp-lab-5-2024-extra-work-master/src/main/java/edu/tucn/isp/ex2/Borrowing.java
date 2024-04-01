package edu.tucn.isp.ex2;

import java.io.ObjectInputFilter;
import java.time.LocalDate;

public class Borrowing {
    private String clientId;
    private String bookId;
    private LocalDate borrowDate;
    private LocalDate returnDate;
    private Status status;

    public Borrowing(String clientId, String bookId, LocalDate borrowDate, LocalDate returnDate, Status status) {
        this.clientId = clientId;
        this.bookId = bookId;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.status = status;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
