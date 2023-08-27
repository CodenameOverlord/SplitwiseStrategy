package model;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;


public class UserPQ implements Comparable<UserPQ>{
    String user;
    Integer amount;
    Boolean hasPaid;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Boolean getHasPaid() {
        return hasPaid;
    }

    public void setHasPaid(Boolean hasPaid) {
        this.hasPaid = hasPaid;
    }

    public UserPQ(String user, Integer amount, Boolean hasPaid) {
        this.user = user;
        this.amount = amount;
        this.hasPaid = hasPaid;
    }

    @Override
    public int compareTo(UserPQ userPQ) {
        return userPQ.amount - this.amount;
    }
}
