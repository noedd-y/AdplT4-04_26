package strategy;
import entity.Book;
import java.util.ArrayList;
import java.util.Comparator;

public class SortDatePublished implements SortStrategyInterface {
    @Override
    public void sortBooks(ArrayList<Book> books) {
        System.out.println("Sorting books by date published...");
        
        books.sort(Comparator.comparing(Book::getPublishedDate));
    }

}
