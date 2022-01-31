package com.nevexis.bankspring.controller;


import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.DocumentException;
import com.nevexis.bankspring.dto.AccountDTO;
import com.nevexis.bankspring.dto.CreateAccountDTO;
import com.nevexis.bankspring.dto.MessageDTO;
import com.nevexis.bankspring.report.AccountPDFExporter;

import com.nevexis.bankspring.model.Account;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/account")
public class AccountController extends BaseController {

    @GetMapping("/export/pdf")
    public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");

        String currentDateTime = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss").format(new Date());
        response.setHeader("Content-Disposition", "attachment; filename=accounts" + currentDateTime + ".pdf");

        new AccountPDFExporter(accountService.getAllAccounts()).export(response.getOutputStream());
    }

    @GetMapping("/export/pdf/zip")
    public void exportToPDFZip(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf/zip");

        String currentDateTime = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss").format(new Date());
        response.setHeader("Content-Disposition", "attachment; filename=accounts" + currentDateTime + ".zip");

        try (ZipOutputStream zippedOut = new ZipOutputStream(response.getOutputStream())) {
            ZipEntry zipEntry = new ZipEntry("accounts.pdf");
            zippedOut.putNextEntry(zipEntry);
            new AccountPDFExporter(accountService.getAllAccounts()).export(zippedOut);
            zippedOut.closeEntry();
        } catch (Exception e) {
            System.out.println();
        }
    }

    @GetMapping("/export/excel")
    public void getFile(HttpServletResponse response) throws IOException {
        response.setContentType("application/vnd.ms-excel");

        String currentDateTime = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss").format(new Date());
        response.setHeader("Content-Disposition", "attachment; filename=accounts" + currentDateTime + ".xlsx");

        excelFileService.load(response.getOutputStream());
    }

    @GetMapping("/export/excel/zip")
    public void getFileZip(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/excel/zip");

        String currentDateTime = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss").format(new Date());
        response.setHeader("Content-Disposition", "attachment; filename=accounts" + currentDateTime + ".zip");

        try (ZipOutputStream zippedOut = new ZipOutputStream(response.getOutputStream())) {
            ZipEntry zipEntry = new ZipEntry("accounts.xlsx");
            zippedOut.putNextEntry(zipEntry);
            excelFileService.load(zippedOut);
            zippedOut.closeEntry();
        } catch (Exception e) {
            System.out.println();
        }
    }

    @GetMapping(path = "/get")
    public List<AccountDTO> getAllAccounts() {
        return accountService.getAllAccounts().stream()
                .map(account -> modelMapper.map(account, AccountDTO.class)).collect(Collectors.toList());
    }

    @PostMapping(path = "/post")
    public ResponseEntity<AccountDTO> createAccount(@RequestBody CreateAccountDTO accountDto) {
        logger.debug("entering createAccount.... ");
        Account account = accountService.createAccount(modelMapper.map(accountDto, Account.class));
        return new ResponseEntity<AccountDTO>(modelMapper.map(account, AccountDTO.class), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageDTO> deleteAccount(@PathVariable Long id) {
        accountService.deleteAccount(id);
        return new ResponseEntity<MessageDTO>(new MessageDTO("Account deleted!"), HttpStatus.OK);
    }
}
