package strategy;

import model.Transaction;
import model.UserPQ;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class PriorityQueueStrategy implements SettlementStrategyDesign{
    @Override
    public List<Transaction> settlement(Map<String, Integer> balanceSheet) {
        List<Transaction> transactionList = new ArrayList<>();
        PriorityQueue <UserPQ> pqShared = new PriorityQueue<>();
        PriorityQueue <UserPQ> pqPaid = new PriorityQueue<>();
        for(String user: balanceSheet.keySet()){
            if(balanceSheet.get(user)>0){
                pqPaid.add(new UserPQ(user, balanceSheet.get(user), true));
            }
            else{
                pqShared.add(new UserPQ(user, -1*balanceSheet.get(user), false));
            }
        }


        while(!pqShared.isEmpty() && !pqPaid.isEmpty()){
            UserPQ paidBy = pqPaid.remove();
            UserPQ sharedBy = pqShared.remove();
            int amountRem = paidBy.getAmount()-sharedBy.getAmount();
            Transaction t = null;
            if(amountRem>0){
                t = new Transaction(sharedBy.getUser(), paidBy.getUser(), sharedBy.getAmount()+"");
                paidBy.setAmount(amountRem);
                pqPaid.add(paidBy);
            }
            else if(amountRem<0){
                t = new Transaction(sharedBy.getUser(), paidBy.getUser(), paidBy.getAmount()+"");
                sharedBy.setAmount(-1*amountRem);
                pqShared.add(sharedBy);
            }
            else{
                t = new Transaction(sharedBy.getUser(), paidBy.getUser(), sharedBy.getAmount()+"");
            }
            transactionList.add(t);
        }

        return transactionList;
    }
}
