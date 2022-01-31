package com.nevexis.bankspring;

import com.nevexis.bankspring.model.Transaction;
import com.nevexis.bankspring.service.TransactionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;

@SpringBootTest
public class TransactionTest {

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    TransactionService transactionService;

    /*@Test
    @Transactional
    void newTransactionTest() {
        Transaction transaction = new Transaction();
        transaction.setIban("test1");
        transactionService.newTransaction(,transaction.getId(), BigDecimal.valueOf(1234));
    }*/
}
