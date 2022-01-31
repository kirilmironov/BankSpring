package com.nevexis.bankspring;

//мокване-заместваме функционалния обект с фалшив; хубаво е да има интерфейс

import com.nevexis.bankspring.controller.AccountController;
import com.nevexis.bankspring.dto.AccountDTO;
import com.nevexis.bankspring.dto.CreateAccountDTO;
import com.nevexis.bankspring.model.Account;
import com.nevexis.bankspring.service.AccountService;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest
public class AccountTestWithMockito {

    @Autowired
    private MockMvc mockMvc;

    /*@MockBean
    private AccountService accountService;*/

    @InjectMocks
    AccountController accountController;

    @Mock
    AccountService accountService;

    @Test
    public void testCreateAccount() {
        /*List<Account> accounts = new ArrayList<>();
        Account account = new Account();
        account.setId(1);
        account.setName("kiro");
        account.setBalance(BigDecimal.valueOf(1000));
        account.setEgn("97597656");
        Mockito.when(accountService.getAllAccounts()).thenReturn(accounts);
        mockMvc.perform(get("/getMapping")).andExpect(status().isOk()).andExpect(jsonPath("$", Matchers.hasSize(1)))
                .andExpect(jsonPath("$[0].name", Matchers.equalTo("kiro")));*/

    }


}
