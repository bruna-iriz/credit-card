package br.com.biv.creditcard.controller;

import br.com.biv.creditcard.controller.mapper.transaction.TransactionToTransactionResourceMapper;
import br.com.biv.creditcard.controller.resource.transaction.TransactionRequest;
import br.com.biv.creditcard.controller.resource.transaction.TransactionResponse;
import br.com.biv.creditcard.domain.model.Transaction;
import br.com.biv.creditcard.domain.service.TransactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;
import java.util.Optional;

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
    public TransactionResponse createTransaction(@RequestBody TransactionRequest transactionRequest) {
        log.info("[POST][REQUEST]: Creating transaction {}", transactionRequest);
        Transaction transaction = transactionToTransactionResourceMapper.convertToTransaction(transactionRequest);
        Transaction transactionSaved = transactionService.save(transaction);
        return transactionToTransactionResourceMapper.convertToTransactionResponse(transactionSaved);
    }

    @GetMapping("/{transactionId}")
    public TransactionResponse getById(@PathVariable(value = "transactionId", required = true) Long transactionId) {
        log.info("[GET-BY-ID][REQUEST]: Searching for accountId {}", transactionId);
        Optional<Transaction> transactionById = transactionService.findById(transactionId);
        final TransactionResponse transactionResponse = transactionToTransactionResourceMapper.convertToTransactionResponse(transactionById.get());
        log.info("[GET-BY-ID][RESPONSE] Found cardholder information.");
        return transactionResponse;
    }


    @GetMapping
    public ResponseEntity<List<TransactionResponse>> listAll() {
        log.info("[LIST-ALL] [REQUEST]: Listing all transactions");
        List<Transaction> transactions = transactionService.listAll();
        List<TransactionResponse> transactionResponse = transactionToTransactionResourceMapper.convertToTransactionsResponseList(transactions);
        log.info("[LIST-ALL][RESPONSE] Successfully listed transactions");
        return ResponseEntity.status(HttpStatus.OK).body(transactionResponse);
    }
}
