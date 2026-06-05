package strategy.booksort;
import entity.Book;
import strategy.SortStrategyInterface;

import java.util.ArrayList;
import java.util.Comparator;

public class SortDatePublished implements SortStrategyInterface<Book> {
    @Override
    public void sort(ArrayList<Book> data) {
        System.out.println("Sorting books by date published...");
        
        data.sort(Comparator.comparing(Book::getPublishedDate));
    }

}
