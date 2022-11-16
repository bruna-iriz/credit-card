package br.com.biv.creditcard.controller.resource.account;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.math.BigDecimal;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountResponse {

    private Long accountId;
    private String documentNumber;
    private BigDecimal accountBalance;

}
