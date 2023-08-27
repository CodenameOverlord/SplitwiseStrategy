package strategy;

import model.Transaction;

import java.util.List;
import java.util.Map;

public interface SettlementStrategyDesign {
    public List<Transaction> settlement(Map<String, Integer> balanceSheet);

}
