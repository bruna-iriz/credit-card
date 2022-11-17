package br.com.biv.creditcard.controller.mapper.transaction;

import br.com.biv.creditcard.controller.resource.merchant.MerchantRequest;
import br.com.biv.creditcard.controller.resource.transaction.TransactionRequest;
import br.com.biv.creditcard.controller.resource.transaction.TransactionResponse;
import br.com.biv.creditcard.domain.exception.transaction.PaymentNotValidException;
import br.com.biv.creditcard.domain.model.Merchant;
import br.com.biv.creditcard.domain.model.Transaction;
import br.com.biv.creditcard.domain.service.util.ValidateBenefitsCategories;
import br.com.biv.creditcard.domain.service.util.ValidateTransactionMCC;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class TransactionToTransactionResourceMapper {

    private final ModelMapper modelMapper;
    private final ValidateBenefitsCategories validateBenefitsCategories;
    private final ValidateTransactionMCC validateTransactionMCC;

    public Transaction convertToTransaction(TransactionRequest transactionRequest) {
            return modelMapper.map(transactionRequest, Transaction.class);
        }

//    public Transaction convertToTransaction(TransactionRequest transactionRequest) {
//        if (validateTransactionMCC.isValidMCCTransaction(transactionRequest)) {
//
//            try {
//                transactionRequest.setTotalAmount(validateAmountBenefit(transactionRequest));
//                Transaction transaction = modelMapper.map(transactionRequest, Transaction.class);
//                System.out.println("TRANSACTION VALID ");
//                return transaction;
//            } catch (PaymentNotValidException e) {
//                return null;
//            }
//        }

//        final Transaction transaction = modelMapper.map(transactionRequest, Transaction.class);
//        System.out.println("TRANSACTION VALID ");
//        transaction.setTotalAmount(transaction.getTotalAmount().negate());
//        return transaction;
//    }

//    public BigDecimal validateAmountBenefit(TransactionRequest transactionRequest) {
//        return validateBenefitsCategories.isBenefits(transactionRequest) ? transactionRequest.getTotalAmount().negate() : transactionRequest.getTotalAmount();
//    }

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
