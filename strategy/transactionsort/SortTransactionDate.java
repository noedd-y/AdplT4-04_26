package strategy.transactionsort;
import entity.Transaction;
import java.util.ArrayList;
import java.util.Comparator;
import strategy.SortStrategyInterface;

public class SortTransactionDate implements SortStrategyInterface<Transaction> {
    @Override
    public void sort(ArrayList<Transaction> data) {
        System.out.println("Sorting transactions by date...");
        
        data.sort(Comparator.comparing(Transaction::getTransactionDate));
    }

}
