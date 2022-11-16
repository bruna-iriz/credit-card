package br.com.biv.creditcard.domain.service;

import br.com.biv.creditcard.domain.model.Transaction;

public interface TransactionService {
    Transaction save(Transaction transaction);
}
