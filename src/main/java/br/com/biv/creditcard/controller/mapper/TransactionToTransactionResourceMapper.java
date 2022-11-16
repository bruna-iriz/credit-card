package br.com.biv.creditcard.controller.mapper;

import br.com.biv.creditcard.controller.TransactionRequest;
import br.com.biv.creditcard.controller.TransactionResponse;
import br.com.biv.creditcard.domain.model.Transaction;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class TransactionToTransactionResourceMapper {

    private final ModelMapper modelMapper;

    public Transaction convertToTransaction(TransactionRequest transactionRequest) {
        final Transaction transaction = modelMapper.map(transactionRequest, Transaction.class);
        return transaction;
    }

    public TransactionResponse convertToTransactionResponse(Transaction transaction) {
        return modelMapper.map(transaction, TransactionResponse.class);
    }

    public List<TransactionResponse> convertToTransactionsResponseList(List<Transaction> transactions) {
        return transactions
                .stream()
                .map(this::convertToTransactionResponse)
                .collect(Collectors.toList());
    }
}
