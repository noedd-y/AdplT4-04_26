package strategy.booksort;
import entity.Book;
import strategy.SortStrategyInterface;

import java.util.ArrayList;
import java.util.Comparator;

public class SortTitle implements SortStrategyInterface<Book> {
    @Override
    public void sort(ArrayList<Book> data) {
        System.out.println("Sorting books by title...");
        
        data.sort(Comparator.comparing(Book::getTitle));
    }

}
