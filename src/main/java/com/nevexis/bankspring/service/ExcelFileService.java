package com.nevexis.bankspring.service;

import com.nevexis.bankspring.report.ExcelHelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.io.IOException;
import java.io.OutputStream;

@Service
public class ExcelFileService {

    @Autowired
    AccountService accountService;

    public void load(OutputStream out) throws IOException {
        ExcelHelper.accountsToExcel(accountService.getAllAccounts(), out);
    }
}
