package edu.tucn.isp.ex2;

import java.time.LocalDate;

record Book(String bookId, String author, Author title, LocalDate publicationDate, Publisher publisher,
            BookGenre genre, int numOfPages) {
    public boolean equalsIgnoreCase(String title) {
        return this.title.equalsIgnoreCase(title);
    }

}
