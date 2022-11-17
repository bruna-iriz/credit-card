package br.com.biv.creditcard.domain.service;

import br.com.biv.creditcard.controller.resource.transaction.TransactionRequest;
import br.com.biv.creditcard.domain.exception.transaction.PaymentNotValidException;
import br.com.biv.creditcard.domain.model.Transaction;
import br.com.biv.creditcard.domain.service.util.ValidateBenefitsCategories;
import br.com.biv.creditcard.domain.service.util.ValidateTransactionMCC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ValidateUsecase {

    @Autowired
    ValidateBenefitsCategories validateBenefitsCategories;
    @Autowired
    ValidateTransactionMCC validateTransactionMCC;

    public Transaction validar(Transaction transaction) {
        if (validateTransactionMCC.isValidMCCTransaction(transaction)) {

            try {
                transaction.setTotalAmount(validateAmountBenefit(transaction));
                System.out.println("TRANSACTION VALID ");
                transaction.setTotalAmount(transaction.getTotalAmount().negate());
            } catch (PaymentNotValidException e) {
                return null;
            }
        }
        return transaction;
    }

    public BigDecimal validateAmountBenefit(Transaction transaction) {
        return validateBenefitsCategories.isBenefits(transaction) ? transaction.getTotalAmount().negate() : transaction.getTotalAmount();

    }

//    public BigDecimal validateAmountBenefit(TransactionRequest transactionRequest) {
//        return validateBenefitsCategories.isBenefits(transactionRequest) ? transactionRequest.getTotalAmount().negate() : transactionRequest.getTotalAmount();
//
//    }

}
