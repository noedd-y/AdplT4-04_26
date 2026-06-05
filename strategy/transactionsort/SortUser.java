package strategy.transactionsort;
import entity.Transaction;
import java.util.ArrayList;
import java.util.Comparator;

import strategy.SortDirection;
import strategy.SortStrategyInterface;

public class SortUser implements SortStrategyInterface<Transaction> {
    @Override
    public void sort(ArrayList<Transaction> data, SortDirection dir) {
        System.out.println("Sorting transactions by user...");
        
        Comparator<Transaction> comparator = Comparator.comparing(t -> ((Transaction) t).getUser().getName());

        if (dir == SortDirection.DESC) {
            comparator = comparator.reversed();
        }

        data.sort(comparator);
    }
}
