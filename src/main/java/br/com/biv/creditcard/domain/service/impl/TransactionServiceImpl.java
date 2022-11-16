package br.com.biv.creditcard.domain.service.impl;

import br.com.biv.creditcard.domain.model.Transaction;
import br.com.biv.creditcard.domain.repository.TransactionRepository;
import br.com.biv.creditcard.domain.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Override
    public Transaction save(final Transaction transaction) {

        return transactionRepository.save(transaction);
    }
}
