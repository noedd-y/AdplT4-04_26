package strategy;
import entity.Book;
import java.util.ArrayList;
import java.util.Comparator;

public class SortTitle implements SortStrategyInterface {
    @Override
    public void sortBooks(ArrayList<Book> books) {
        System.out.println("Sorting books by title...");
        
        books.sort(Comparator.comparing(Book::getTitle));
    }

}
