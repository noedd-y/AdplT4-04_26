package strategy.transactionsort;
import entity.Transaction;
import java.util.ArrayList;
import java.util.Comparator;

import strategy.SortDirection;
import strategy.SortStrategyInterface;

public class SortTransactionDate implements SortStrategyInterface<Transaction> {
    @Override
    public void sort(ArrayList<Transaction> data, SortDirection dir) {
        System.out.println("Sorting transactions by date...");
        
        Comparator<Transaction> comparator = Comparator.comparing(Transaction::getTransactionDate);
        
        if(dir == SortDirection.DESC){
            comparator = comparator.reversed();
        }

        data.sort(comparator);
    }

}
