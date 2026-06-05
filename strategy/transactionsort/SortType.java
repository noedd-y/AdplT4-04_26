package strategy.transactionsort;
import entity.Transaction;
import java.util.ArrayList;
import java.util.Comparator;
import strategy.SortStrategyInterface;

public class SortType implements SortStrategyInterface<Transaction> {
    @Override
    public void sort(ArrayList<Transaction> data) {
        System.out.println("Sorting transactions by type...");
        
        data.sort(Comparator.comparing(Transaction::getType));
    }

}
