package edu.tucn.isp.ex2;

/**
 * @author Radu Miron
 */
public class Exercise2 {
    public static void main(String[] args) {
        LibraryManagerImpl libraryManager = new LibraryManagerImpl();
        CliUserInterface cliInterface = new CliUserInterface(libraryManager);

        cliInterface.addNewBook();

        cliInterface.addExistingBook();

        cliInterface.addCustomer();

        cliInterface.removeCustomer();

        cliInterface.searchBookByTitle();

        cliInterface.searchBookByAuthor();

        cliInterface.borrowBook();

        cliInterface.returnBook();
    }
}
