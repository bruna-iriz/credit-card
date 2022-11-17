package br.com.biv.creditcard.domain.service;

import br.com.biv.creditcard.domain.model.Transaction;

import java.util.List;
import java.util.Optional;

public interface TransactionService {
    Transaction save(Transaction transaction);

    Optional<Transaction> findById(Long transactionId);

    List<Transaction> listAll();

}
