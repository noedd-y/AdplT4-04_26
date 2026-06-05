package strategy.booksort;
import entity.Book;
import strategy.*;

import java.util.ArrayList;
import java.util.Comparator;

public class SortTitle implements SortStrategyInterface<Book> {
    @Override
    public void sort(ArrayList<Book> data, SortDirection dir) {
        System.out.println("Sorting books by title...");

        Comparator<Book> comparator = Comparator.comparing(Book::getTitle);
        
        if(dir == SortDirection.DESC){
            comparator = comparator.reversed();
        }

        data.sort(comparator);
    }

}
