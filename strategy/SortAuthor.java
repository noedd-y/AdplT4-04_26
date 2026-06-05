package strategy;
import entity.Book;
import java.util.ArrayList;
import java.util.Comparator;

public class SortAuthor implements SortStrategyInterface {
    @Override
    public void sortBooks(ArrayList<Book> books) {
        System.out.println("Sorting books by author...");
        
        books.sort(Comparator.comparing(Book::getAuthor));
    }

}
