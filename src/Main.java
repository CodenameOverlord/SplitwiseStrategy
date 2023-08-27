import model.Transaction;
import strategy.PriorityQueueStrategy;
import strategy.SettlementStrategyDesign;
import strategy.SettlementStrategyHelper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Map<String, Integer> balanceSheet = new HashMap<>();
        balanceSheet.put("A", 100);
        balanceSheet.put("B", 100);
//        balanceSheet.put("A", -75);
//        balanceSheet.put("B", -75);
        balanceSheet.put("C", -135);
        balanceSheet.put("D", -65);

        List<Transaction> t = SettlementStrategyHelper.showSettlement(balanceSheet, "PriorityQueueStrategy");
        System.out.println(t.toString());

    }
}