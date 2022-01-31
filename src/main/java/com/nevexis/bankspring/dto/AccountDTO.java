package com.nevexis.bankspring.dto;

import java.math.BigDecimal;

public class AccountDTO {

    private Long id;

    private String name;

    private BigDecimal balance;

    private String egn;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "AccountDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                ", egn='" + egn + '\'' +
                '}';
    }
}
