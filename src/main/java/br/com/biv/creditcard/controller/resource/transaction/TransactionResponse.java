package br.com.biv.creditcard.controller.resource.transaction;

import br.com.biv.creditcard.domain.enums.MCC;
import br.com.biv.creditcard.domain.model.Account;
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
    private MCC mcc;
    private String merchant;
    private Long transactionId;
    private BigDecimal totalAmount;
//    private BigDecimal accountBalance;
    //    private StatusTransaction statusTransaction;
    private LocalDateTime eventDate = LocalDateTime.now();

}
