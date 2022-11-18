package br.com.biv.creditcard.domain.service.util;

import br.com.biv.creditcard.domain.enums.StatusTransaction;
import br.com.biv.creditcard.domain.exception.transaction.PaymentNotValidException;
import br.com.biv.creditcard.domain.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AuthorizerUseCase {


    @Autowired
    ValidateBenefitsCategories validateBenefitsCategories;
    @Autowired
    ValidateTransactionMCC validateTransactionMCC;

    public void validateAuthorizer(Transaction transaction) {
        if (validateTransactionMCC.isValidMCCTransaction(transaction)) {
            try {
                transaction.setTotalAmount(validateAmountBenefit(transaction));
            } catch (PaymentNotValidException e) {
                transaction.setStatusTransaction(StatusTransaction.REJECTED);
            }
        }
    }

    public BigDecimal validateAmountBenefit(Transaction transaction) {
        final var amountWhenIsBenefit = validateBenefitsCategories.isBenefits(transaction) ? transaction.getAmount().negate() : transaction.getAmount();
        return amountWhenIsBenefit;
    }

}
