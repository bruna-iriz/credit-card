package br.com.biv.creditcard.controller.resource.transaction;

import br.com.biv.creditcard.domain.enums.BenefitsCategories;
import br.com.biv.creditcard.domain.enums.MCC;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TransactionRequest {

    @JsonProperty("account_id")
    private Long accountId;
    @JsonProperty("benefits_categories")
    private BenefitsCategories benefitsCategories;
    @JsonProperty("mcc")
    private MCC mcc;
    @JsonProperty("total_amount")
    private BigDecimal totalAmount;
    private String merchant;
}
