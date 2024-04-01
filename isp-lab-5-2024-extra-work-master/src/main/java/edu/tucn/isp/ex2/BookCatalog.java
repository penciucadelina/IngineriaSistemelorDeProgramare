package edu.tucn.isp.ex2;

import java.util.ArrayList;
import java.util.List;

public class BookCatalog {
    private Book book;
    private int totalNum;
    private int availableNum;

    public BookCatalog(Book book, int totalNum, int availableNum) {
        this.book = book;
        this.totalNum = totalNum;
        this.availableNum = availableNum;
    }

    public void addBooks(int num) {
        this.totalNum += num;
        this.availableNum += num;
    }

    public void borrowBook() {
        if (availableNum > 0) {
            availableNum--;
            System.out.println("Book borrowed successfully.");
        } else {
            System.out.println("No available copies of this book.");
        }
    }

    public void returnBook() {
        availableNum++;
        System.out.println("Book returned successfully.");
    }

    // Getters and setters
    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    public int getAvailableNum() {
        return availableNum;
    }

    public void setAvailableNum(int availableNum) {
        this.availableNum = availableNum;
    }
}