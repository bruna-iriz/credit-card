package br.com.biv.creditcard.controller;

import br.com.biv.creditcard.controller.mapper.transaction.TransactionToTransactionResourceMapper;
import br.com.biv.creditcard.controller.resource.transaction.TransactionRequest;
import br.com.biv.creditcard.controller.resource.transaction.TransactionResponse;
import br.com.biv.creditcard.domain.model.Transaction;
import br.com.biv.creditcard.domain.service.TransactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.validation.Valid;

@Slf4j
@EnableSwagger2
@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    TransactionService transactionService;
    @Autowired
    TransactionToTransactionResourceMapper transactionToTransactionResourceMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TransactionResponse createTransaction(@RequestBody @Valid TransactionRequest transactionRequest) {
        log.info("[POST][REQUEST]: Creating transaction {}", transactionRequest);
        Transaction transaction = transactionToTransactionResourceMapper.convertToTransaction(transactionRequest);
        Transaction transactionSaved = transactionService.save(transaction);
        TransactionResponse transactionResponse = transactionToTransactionResourceMapper.convertToTransactionResponse(transactionSaved);
        log.info("[POST][RESPONSE]: Transaction create with success.");
        return transactionResponse;
    }
}
