package br.com.biv.creditcard.controller.resource.transaction;

import br.com.biv.creditcard.domain.enums.MCC;
import br.com.biv.creditcard.domain.model.Merchant;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TransactionResponse {

    private Long accountId;
    private BigDecimal totalAmount;
    private MCC mcc;
    private String merchant;
    private Long transactionId;
//    private StatusTransaction statusTransaction;
    private LocalDateTime eventDate = LocalDateTime.now();

    public String concat(Merchant merchant) {
        return merchant.getName()
                .concat(merchant.getState())
                .concat(merchant.getCountry());
    }

}
