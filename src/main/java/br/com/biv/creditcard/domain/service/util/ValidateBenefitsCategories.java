package br.com.biv.creditcard.domain.service.util;

import br.com.biv.creditcard.controller.resource.transaction.TransactionRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static br.com.biv.creditcard.domain.enums.BenefitsCategories.*;


@Service
@AllArgsConstructor
public class ValidateBenefitsCategories {

    public boolean isBenefits(TransactionRequest transactionRequest) {

        if (transactionRequest.getBenefitsCategories().equals(FOOD)) {
            System.out.println("É Beneficio!!! FOOD");
            return true;
        } else if (transactionRequest.getBenefitsCategories().equals(MEAL)) {
            System.out.println("É Beneficio!!! MEAL");
            return true;
        } else {
            if (transactionRequest.getBenefitsCategories().equals(CULTURE)) {
                System.out.println("É Beneficio!!! CULTURE");
                return true;
            } else {
                System.out.println("NÃO Beneficio!!! CASH");
                return false;
            }
        }
    }
}
