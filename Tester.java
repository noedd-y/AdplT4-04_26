import entity.*;
import facade.*;
import strategy.booksort.*;
public class Tester {
    public static void main(String[] args) {
        // Create some users
        User user1 = new User("Alice", "Smith");
        User user2 = new User("Bob", "Johnson");
        User user3 = new User("Charlie", "Brown");


        // Create books        
        Book book1 = new Book("The Great Gatsby", "Fiction", "F. Scott Fitzgerald", "1923");
        Book book2 = new Book("To Kill a Mockingbird", "Fiction", "Harper Lee", "1910");
        Book book3 = new Book("A Brief History of Time", "Science", "Stephen Hawking", "1988");

        // Create library facade
        LibraryFacade library = new LibraryFacade();
        
        library.addMember(user1);
        library.addMember(user2);
        library.addMember(user3);
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        System.out.println(library.borrowBook(book1, user1));
        System.out.println(library.reserveBook(book2, user2));

        System.out.println(library.showBookList());
        System.out.println(library.showMemberList());

        library.sortBooks(new SortState());
        System.out.println(library.showBookList());
    }
}
