package com.nevexis.bankspring.service;

import com.nevexis.bankspring.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Service
public class AccountService {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public List<Account> getAllAccounts() {
        return entityManager.createQuery("Select a from Account a ", Account.class).setMaxResults(100).getResultList();
    }

    @Transactional
    public Account createAccount(Account accountRequest) {
        entityManager.persist(accountRequest);
        return accountRequest;
    }

    public void deleteAccount(Long id) {
        entityManager.remove(entityManager.find(Account.class, id));
    }
}
