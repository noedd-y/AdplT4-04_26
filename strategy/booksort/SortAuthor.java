package strategy.booksort;
import entity.Book;
import java.util.ArrayList;
import java.util.Comparator;

import strategy.SortDirection;
import strategy.SortStrategyInterface;

public class SortAuthor implements SortStrategyInterface<Book> {
    @Override
    public void sort(ArrayList<Book> data, SortDirection dir) {
        System.out.println("Sorting books by author...");
    
        Comparator<Book> comparator = Comparator.comparing(Book::getAuthor);
        
        if(dir == SortDirection.DESC){
            comparator = comparator.reversed();
        }

        data.sort(comparator);
    }

}
