package strategy.booksort;
import entity.Book;
import strategy.SortDirection;
import strategy.SortStrategyInterface;

import java.util.ArrayList;
import java.util.Comparator;

public class SortDatePublished implements SortStrategyInterface<Book> {
    @Override
    public void sort(ArrayList<Book> data, SortDirection dir) {
        System.out.println("Sorting books by date published...");

        Comparator<Book> comparator = Comparator.comparing(Book::getPublishedDate);
        
        if(dir == SortDirection.DESC){
            comparator = comparator.reversed();
        }

        data.sort(comparator);
    }

}
