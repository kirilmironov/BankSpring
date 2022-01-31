package com.nevexis.bankspring.dto;

import java.math.BigDecimal;

public class CreateAccountDTO {

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


}
