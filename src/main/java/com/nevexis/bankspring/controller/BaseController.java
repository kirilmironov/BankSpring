package com.nevexis.bankspring.controller;


import com.nevexis.bankspring.dto.MessageDTO;
import com.nevexis.bankspring.service.AccountService;
import com.nevexis.bankspring.service.ExcelFileService;
import com.nevexis.bankspring.service.TransactionService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;


public class BaseController {

    protected Logger logger = LoggerFactory.getLogger("Controller Layer ...");

    @Autowired
    protected ModelMapper modelMapper;

    @Autowired
    protected AccountService accountService;

    @Autowired
    protected TransactionService transactionService;

    @Autowired
    ExcelFileService excelFileService;

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<MessageDTO> processValidationError(Throwable ex) {
        logger.error("Error in controller: ", ex);
        return new ResponseEntity<>(new MessageDTO(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
