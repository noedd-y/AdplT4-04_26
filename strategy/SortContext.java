package strategy;
import entity.Book;
import java.util.ArrayList;
public class SortContext {
    private SortStrategyInterface sortStrategy;

    public void setSortStrategy(SortStrategyInterface sortStrategy) {
        this.sortStrategy = sortStrategy;
    }

    public void clearSortStrategy() {
        this.sortStrategy = null;
    }

    public void executeSort(ArrayList<Book> books) {
        if (sortStrategy != null) {
            sortStrategy.sortBooks(books);
        } else {
            System.out.println("No sorting strategy set.");
        }
    }
}
