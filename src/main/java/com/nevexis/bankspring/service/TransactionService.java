package com.nevexis.bankspring.service;

import com.nevexis.bankspring.model.Account;
import com.nevexis.bankspring.model.Transaction;
import com.nevexis.bankspring.enums.TransactionType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import java.util.List;

@Transactional
@Service
public class TransactionService {

    @PersistenceContext
    EntityManager entityManager;

    public List<Transaction> getAllTransactions() {
        return entityManager.createQuery("Select t From Transaction t",Transaction.class).setMaxResults(100).getResultList();
    }

    @Transactional
    public void newTransaction(Long fromId, Long toId, BigDecimal amount){
        Account sourceAccount = entityManager.find(Account.class,fromId/*,LockModeType.WRITE*/);
        Account destinationAccount = entityManager.find(Account.class,toId/*,LockModeType.WRITE*/);

        sourceAccount.setBalance(sourceAccount.getBalance().subtract(amount));
        destinationAccount.setBalance(destinationAccount.getBalance().add(amount));

        LocalDateTime time = LocalDateTime.now();

        entityManager.persist(new Transaction(destinationAccount, sourceAccount, amount, time, TransactionType.DEBIT, "IBAN"));
        entityManager.persist(new Transaction(sourceAccount, destinationAccount, amount, time, TransactionType.CREDIT, "IBAN"));
    }
}
