package strategy;
import entity.Book;
import java.util.ArrayList;
import java.util.Comparator;

public class SortCategory implements SortStrategyInterface {
    @Override
    public void sortBooks(ArrayList<Book> books) {
        System.out.println("Sorting books by category...");
        // Implement sorting logic here
        books.sort(Comparator.comparing(Book::getCategory));
    }

}
