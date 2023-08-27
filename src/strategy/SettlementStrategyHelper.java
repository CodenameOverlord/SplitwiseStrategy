package strategy;

import model.Transaction;

import java.util.List;
import java.util.Map;

public class SettlementStrategyHelper {
    public static List<Transaction> showSettlement(Map<String, Integer> balanceSheet, String strategy){
        switch(strategy){
            case("PriorityQueueStrategy"):
                PriorityQueueStrategy pqs = new PriorityQueueStrategy();
                return pqs.settlement(balanceSheet);
        }
        return null;
    }
}
