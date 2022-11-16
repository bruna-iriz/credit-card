package br.com.biv.creditcard.domain.service.util;

import br.com.biv.creditcard.controller.resource.transaction.TransactionRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static br.com.biv.creditcard.domain.enums.MCC.*;


@Service
@AllArgsConstructor
public class ValidateTransactionMCC {

    public boolean isValidMCCTransaction(TransactionRequest transactionRequest) {
        if (transactionRequest.getMcc().equals(RESTAURANT)) {
            System.out.println("É MCC!!! FOOD");
            return true;
        } else if (transactionRequest.getMcc().equals(SUPERMARKET)) {
            System.out.println("É MCC!!! MEAL");
            return true;
        } else {
            if (transactionRequest.getMcc().equals(AUDIOVISUAL_MEDIA)) {
                System.out.println("É MCC!!! MERCHANT");
                return true;
            } else {
                System.out.println("NÃO MCC!!! OTHERS");
                return false;
            }
        }

    }
}

