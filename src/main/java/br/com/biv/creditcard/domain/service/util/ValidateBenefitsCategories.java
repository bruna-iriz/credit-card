package br.com.biv.creditcard.domain.service.util;

import br.com.biv.creditcard.controller.resource.transaction.TransactionRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static br.com.biv.creditcard.domain.enums.BenefitsCategoriesEnum.*;


@Service
@AllArgsConstructor
public class ValidateBenefitsCategories {

    public boolean isBenefits(TransactionRequest transactionRequest) {

        if (transactionRequest.getBenefitsCategoriesEnum().equals(FOOD)) {
            System.out.println("É Beneficio!!! FOOD");
            return true;
        } else if (transactionRequest.getBenefitsCategoriesEnum().equals(MEAL)) {
            System.out.println("É Beneficio!!! MEAL");
            return true;
        } else {
            if (transactionRequest.getBenefitsCategoriesEnum().equals(CULTURE)) {
                System.out.println("É Beneficio!!! CULTURE");
                return true;
            } else {
                System.out.println("NÃO Beneficio!!! CASH");
                return false;
            }
        }
    }
}

