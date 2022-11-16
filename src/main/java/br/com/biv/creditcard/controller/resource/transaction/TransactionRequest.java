package br.com.biv.creditcard.controller.resource.transaction;

import br.com.biv.creditcard.domain.enums.BenefitsCategoriesEnum;
import br.com.biv.creditcard.domain.enums.MCCEnum;
import br.com.biv.creditcard.domain.model.Account;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
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
    private BenefitsCategoriesEnum benefitsCategoriesEnum;
    @NotEmpty
    @JsonProperty("total_amount")
    private BigDecimal totalAmount;
    @JsonProperty("mcc")
    private MCCEnum mccEnum;
    private String merchant;
    @ManyToOne(optional = false)
    private Account account;

}
