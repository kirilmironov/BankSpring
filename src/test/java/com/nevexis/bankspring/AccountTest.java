package com.nevexis.bankspring;

import com.nevexis.bankspring.model.Account;
import com.nevexis.bankspring.service.AccountService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertThrows;

@SpringBootTest
public class AccountTest {

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    AccountService accountService;

    private static Account account;


    @BeforeAll
    static void init() {
        account = new Account();
        account.setEgn("test1");
    }

    @Test
    public void getAllAccountsTest() {
        List<Account> accounts = new ArrayList<>();
        Account account = new Account();
        account.setId(1);
        account.setName("kiro");
        account.setBalance(BigDecimal.valueOf(1000));
        account.setEgn("97597656");


        accountService.createAccount(account);
        int expectedAccounts = 1;
        int actual = accountService.getAllAccounts().size();
        Assertions.assertEquals(expectedAccounts,actual);
    }

    @Test
    @Transactional
    public void createAccountTest() {
        /*Account account = new Account();
        account.setEgn("test1");*/
        accountService.createAccount(account);
        //entityManager.persist(account);
        Account accountDB = entityManager.createQuery("SELECT a FROM Account a WHERE a.egn = :pEgn", Account.class)
                .setParameter("pEgn", account.getEgn()).getSingleResult();

        //System.out.println(accountDB.getId()+"    "+ accountDB);
        Assertions.assertNotNull(accountDB);
        Assertions.assertEquals(accountDB.getEgn(), account.getEgn());
    }

    @Test
    @Transactional
    void accountAlreadyExistTest() {
        IllegalStateException illegalStateException = assertThrows(IllegalStateException.class, () -> accountService.createAccount(account));
        Assertions.assertEquals("Account name already exists .....", illegalStateException.getMessage());
    }

    @Test
    @Transactional
    @Rollback(value = false)
    void deleteAccountTest() {
        accountService.deleteAccount(account.getId());

    }



}
