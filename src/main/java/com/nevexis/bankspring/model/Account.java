package com.nevexis.bankspring.model;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class Account extends BaseEntity {

    private String name;

    private BigDecimal balance;

    private String egn;

    public Account() {
    }
    public Account(String name, BigDecimal balance, String egn) {
        this.name = name;
        this.balance = balance;
        this.egn = egn;
    }


 public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getEgn() {
        return egn;
    }

    public void setEgn(String egn) {
        this.egn = egn;
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", balance=" + balance +
                ", egn='" + egn + '\'' +
                '}';
    }
}
