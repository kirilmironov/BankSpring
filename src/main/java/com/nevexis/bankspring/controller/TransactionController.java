package com.nevexis.bankspring.controller;

import com.nevexis.bankspring.dto.MessageDTO;
import com.nevexis.bankspring.dto.TransactionDTO;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/transaction")
public class TransactionController extends BaseController {


    @GetMapping(path = "/get")
    public List<TransactionDTO> getAllTransactions() {
        return transactionService.getAllTransactions().stream()
                .map(transaction -> modelMapper.map(transaction, TransactionDTO.class)).collect(Collectors.toList());
    }

    @PostMapping(path = "/post")
    public ResponseEntity<MessageDTO> newTransfer(@RequestParam Long sourceAccount, @RequestParam Long destinationAccount, @RequestParam BigDecimal amount) {
        logger.debug("Creating new transfer! ");
        transactionService.newTransaction(sourceAccount, destinationAccount, amount);
        return new ResponseEntity<>(new MessageDTO("Transfer created!"), HttpStatus.OK);
    }

}
