package strategy;
import java.util.ArrayList;
public class SortContext<T> {
    private SortStrategyInterface<T> sortStrategy;

    public SortContext() {
        this.sortStrategy = null;
    }
    public SortContext(SortStrategyInterface<T> sortStrategy) {
        this.sortStrategy = sortStrategy;
    }

    public void setSortStrategy(SortStrategyInterface<T> sortStrategy) {
        this.sortStrategy = sortStrategy;
    }

    public void clearSortStrategy() {
        this.sortStrategy = null;
    }

    public void executeSort(ArrayList<T> data) {
        if (sortStrategy != null) {
            sortStrategy.sort(data);
        } else {
            System.out.println("No sorting strategy set.");
        }
    }
}
