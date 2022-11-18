package br.com.biv.creditcard.domain.service.util;

import br.com.biv.creditcard.domain.model.Transaction;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static br.com.biv.creditcard.domain.enums.BenefitsCategories.*;


@Service
@AllArgsConstructor
public class ValidateBenefitsCategories {
    public boolean isBenefits(Transaction transaction) {

        if (transaction.getBenefitsCategories().equals(FOOD)) {
            return true;
        } else if (transaction.getBenefitsCategories().equals(MEAL)) {
            return true;
        } else {
            if (transaction.getBenefitsCategories().equals(CULTURE)) {
                return true;
            } else {
                return false;
            }
        }
    }
}