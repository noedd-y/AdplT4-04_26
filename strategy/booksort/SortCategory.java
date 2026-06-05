package strategy.booksort;
import entity.Book;
import java.util.ArrayList;
import java.util.Comparator;
import strategy.SortStrategyInterface;

public class SortCategory implements SortStrategyInterface<Book> {
    @Override
    public void sort(ArrayList<Book> data) {
        System.out.println("Sorting books by category...");

        data.sort(Comparator.comparing(Book::getCategory));
    }

}
