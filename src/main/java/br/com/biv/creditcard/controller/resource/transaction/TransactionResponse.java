package br.com.biv.creditcard.controller.resource.transaction;

import br.com.biv.creditcard.domain.enums.MCCEnum;
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
    private MCCEnum mccEnum;
    private String merchant;
    private Long transactionId;
    private LocalDateTime eventDate = LocalDateTime.now();

}
