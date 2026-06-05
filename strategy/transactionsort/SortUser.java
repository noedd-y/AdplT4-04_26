package strategy.transactionsort;
import entity.Transaction;
import java.util.ArrayList;
import java.util.Comparator;
import strategy.SortStrategyInterface;

public class SortUser implements SortStrategyInterface<Transaction> {
    @Override
    public void sort(ArrayList<Transaction> data) {
        System.out.println("Sorting transactions by user...");
        
        data.sort(Comparator.comparing(t -> ((Transaction) t).getUser().getName()));
    }
}
