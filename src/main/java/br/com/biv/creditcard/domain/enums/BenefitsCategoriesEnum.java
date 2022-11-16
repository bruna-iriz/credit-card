package br.com.biv.creditcard.domain.enums;

import lombok.Getter;

import java.util.stream.Stream;

@Getter
public enum BenefitsCategoriesEnum {
    MEAL(0),
    FOOD(1),
    CULTURE(2),
    CASH(null);

    private final Integer value;

    private BenefitsCategoriesEnum(Integer value) {
        this.value = value;
    }

    public static boolean getValue(Integer id) {
        return Stream.of(BenefitsCategoriesEnum.values())
                .anyMatch(benefitsCategoriesEnum -> benefitsCategoriesEnum.value.equals(id));
    }
}
