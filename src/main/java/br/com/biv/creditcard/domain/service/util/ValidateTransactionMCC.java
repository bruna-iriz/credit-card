package br.com.biv.creditcard.domain.service.util;

import br.com.biv.creditcard.domain.model.Transaction;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static br.com.biv.creditcard.domain.enums.MCC.*;


@Service
@AllArgsConstructor
public class ValidateTransactionMCC {


    public boolean isValidMCCTransaction(Transaction transaction) {
        if (transaction.getMcc().equals(RESTAURANT)) {
            System.out.println("É MCC!!! RESTAURANT");
            return true;
        } else if (transaction.getMcc().equals(SUPERMARKET)) {
            System.out.println("É MCC!!! SUPERMARKET");
            return true;
        } else {
            if (transaction.getMcc().equals(AUDIOVISUAL_MEDIA)) {
                System.out.println("É MCC!!! AUDIOVISUAL_MEDIA");
                return true;
            } else {
                System.out.println("NÃO MCC!!! OTHERS");
                return false;
            }
        }

    }
}

